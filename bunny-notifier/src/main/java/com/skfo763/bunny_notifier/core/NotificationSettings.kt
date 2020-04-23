package com.skfo763.bunny_notifier.core

import android.annotation.TargetApi
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.skfo763.bunny_notifier.impls.NotificationSettingsImpl
import com.skfo763.bunny_notifier.impls.ShowImpl
import com.skfo763.bunny_notifier.model.BaseNotification
import com.skfo763.bunny_notifier.model.NotifierChannel

abstract class NotificationSettings(
    context: Context,
    channel: NotifierChannel
): ShowImpl {

    val manager = NotificationManagerCompat.from(context)
    val builder = makeNotificationBuilder(context, channel)

    @TargetApi(24)
    abstract fun setGroup(groupId: String = DEFAULT_GROUP_ID, @DrawableRes groupSmallIconResId: Int)

    @TargetApi(24)
    abstract fun setGroupChannel(groupChannel: NotifierChannel)

    @TargetApi(24)
    abstract fun setGroupClickIntent(clickIntent: PendingIntent)
    abstract fun setAutoCancel(autoCancel: Boolean)
    abstract fun setBase(notifierBase: BaseNotification)
    abstract fun setCustom(remoteViews: RemoteViews)
    abstract fun setClickAction(clickAction: PendingIntent)
    abstract fun setOnlyAlertOnce(isOnlyAlertOnce: Boolean)
    abstract fun setWhen(`when`: Long)
    abstract fun build(): Notification
    abstract fun setColor(@ColorInt color: Int)

    @TargetApi(21)
    abstract fun setPublicVersion(notification: Notification)

    private fun makeNotificationBuilder(context: Context, channel: NotifierChannel) =
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationCompat.Builder(context, channel.channelId)
        } else {
            NotificationCompat.Builder(context)
        }
}