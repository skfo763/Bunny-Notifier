package com.skfo763.bunny_notifier.core

import android.annotation.TargetApi
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.skfo763.bunny_notifier.model.BaseNotification
import com.skfo763.bunny_notifier.model.GroupNotification
import com.skfo763.bunny_notifier.model.NotifierChannel

open class NotifierContextProcessor (
    private val context: Context,
    private val channel: NotifierChannel
): NotificationSettings(context, channel) {

    private var groupNotification = GroupNotification()

    @TargetApi(24)
    override fun setGroup(groupId: String, groupSmallIconResId: Int) {
        if (Build.VERSION.SDK_INT >= 24) {
            // Set group info for summary notification
            groupNotification.smallIconForSystem = groupSmallIconResId
            groupNotification.groupId = groupId

            // Set group info for main notification
            builder.setGroup(groupId)
        }
    }

    @TargetApi(24)
    override fun setGroupChannel(groupChannel: NotifierChannel) {
        if (Build.VERSION.SDK_INT >= 24) {
            if (Build.VERSION.SDK_INT >= 26) {
                manager.createNotificationChannel(
                    NotifierChannel.convertToNotificationChannel(groupChannel))
            }
            groupNotification.groupChannel = groupChannel
        }
    }

    @TargetApi(24)
    override fun setGroupClickIntent(clickIntent: PendingIntent) {
        if(Build.VERSION.SDK_INT >= 24) {
            groupNotification.groupClickIntent = clickIntent
        }
    }

    override fun setAutoCancel(autoCancel: Boolean) {
        builder.setAutoCancel(autoCancel)
    }

    override fun setBase(notifierBase: BaseNotification) {
        builder.setContentTitle(notifierBase.title)
        builder.setContentText(notifierBase.text)
        builder.setSmallIcon(notifierBase.smallIconResId)
        notifierBase.largeIcon?.let { builder.setLargeIcon(it) }
    }

    override fun setCustom(remoteViews: RemoteViews) {
        if (Build.VERSION.SDK_INT >= 24) {
            builder.setCustomContentView(remoteViews)
        } else {
            builder.setContent(remoteViews)
        }
    }

    override fun setClickAction(clickAction: PendingIntent) {
        builder.setContentIntent(clickAction)
    }

    override fun setOnlyAlertOnce(isOnlyAlertOnce: Boolean) {
        builder.setOnlyAlertOnce(isOnlyAlertOnce)
    }

    override fun setWhen(`when`: Long) {
        builder.setWhen(`when`)
    }

    override fun build(): Notification {
        return build(builder)
    }

    @TargetApi(21)
    override fun setColor(color: Int) {
        if (Build.VERSION.SDK_INT >= 21) {
            builder.color = color
        }
    }

    @TargetApi(21)
    override fun setPublicVersion(notification: Notification) {
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setPublicVersion(notification)
        }
    }

    override fun setStyle(style: NotificationCompat.Style) {
        builder.setStyle(style)
    }

    override fun takeBuilder(): NotificationCompat.Builder {
        return builder
    }

    override fun show(notificationId: Int, notification: Notification?) {
        val noti = notification ?: build(builder)
        if (Build.VERSION.SDK_INT >= 24 && (noti.group != null)) {
            showGroupNotification(groupNotification)
        }
        manager.notify(notificationId, noti)
    }

    fun build(builder: NotificationCompat.Builder): Notification {
        return if (Build.VERSION.SDK_INT >= 16) {
            builder.build()
        } else {
            builder.notification
        }
    }

    private fun showGroupNotification(groupNotification: GroupNotification) {
        val builder = if(Build.VERSION.SDK_INT >= 26) {
            NotificationCompat.Builder(context, channel.channelId).also {
                setChannelDataForCompat(builder, groupNotification.groupChannel)
            }
        } else {
           NotificationCompat.Builder(context)
        }
        groupNotification.groupClickIntent?.let { builder.setContentIntent(it) }
        builder.setGroup(groupNotification.groupId)
        builder.setGroupSummary(true)
        builder.setAutoCancel(true)

        manager.notify(
            groupNotification.groupId.hashCode(),
            build(builder).also { it.flags = Notification.FLAG_AUTO_CANCEL }
        )
    }

    private fun setChannelDataForCompat(builder: NotificationCompat.Builder, channel: NotifierChannel) {
        if (Build.VERSION.SDK_INT < 26) {
            if (Build.VERSION.SDK_INT >= 16) {
                builder.priority = channel.importance
            }
            if (channel.isEnableShowLights) {
                builder.setLights(channel.lightColor, 0, 500)
            }
            if (channel.isEnableSound) {
                builder.setSound(channel.sound)
            }
            if (channel.isEnableVibration) {
                builder.setVibrate(channel.vibrationPattern)
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            builder.setVisibility(channel.lockScreenVisibility)
        }
    }

    init {
        setChannelDataForCompat(builder, channel)
    }
}