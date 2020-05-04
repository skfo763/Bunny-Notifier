package com.skfo763.bunny_notifier.core

import android.annotation.TargetApi
import android.app.Notification
import android.app.PendingIntent
import androidx.annotation.ColorInt
import androidx.core.app.NotificationCompat
import com.skfo763.bunny_notifier.impls.BaseImpl
import com.skfo763.bunny_notifier.impls.NotificationSettingsImpl
import com.skfo763.bunny_notifier.model.BaseNotification
import com.skfo763.bunny_notifier.model.CustomNotification
import com.skfo763.bunny_notifier.model.NotifierChannel

class NotifierDataManager(
    private val notificationSettings: NotificationSettings
): BaseImpl, NotificationSettingsImpl {
    override fun setBase(baseData: BaseNotification): NotificationSettingsImpl {
        notificationSettings.setBase(baseData)
        return this
    }

    override fun setCustom(customNotification: CustomNotification): NotificationSettingsImpl {
        notificationSettings.setBase(
            BaseNotification(
                customNotification.titleForSystem,
                customNotification.textForSystem,
                customNotification.smallIconForSystem)
        )
        notificationSettings.setCustom(customNotification.remoteViews)
        return this
    }

    override fun setGroup(
        groupSmallIconResId: Int,
        groupId: String,
        groupChannel: NotifierChannel?
    ): NotificationSettingsImpl {
        notificationSettings.setGroup(groupId, groupSmallIconResId)
        groupChannel?.let { notificationSettings.setGroupChannel(it) }
        return this
    }

    override fun setWhen(whenTimeMillis: Long): NotificationSettingsImpl {
        notificationSettings.setWhen(whenTimeMillis)
        return this
    }

    override fun setOnlyAlertOnce(isOnlyAlertOnce: Boolean): NotificationSettingsImpl {
        notificationSettings.setOnlyAlertOnce(isOnlyAlertOnce)
        return this
    }

    override fun setAutoCancel(autoCancel: Boolean): NotificationSettingsImpl {
        notificationSettings.setAutoCancel(autoCancel)
        return this
    }

    override fun setClickAction(clickAction: PendingIntent): NotificationSettingsImpl {
        notificationSettings.setClickAction(clickAction)
        return this
    }

    @TargetApi(21)
    override fun setColor(@ColorInt color: Int): NotificationSettingsImpl {
        notificationSettings.setColor(color)
        return this
    }

    override fun setGroupClickIntent(clickIntent: PendingIntent): NotificationSettingsImpl {
        notificationSettings.setGroupClickIntent(clickIntent)
        return this
    }

    @TargetApi(21)
    override fun setPublicVersion(notification: Notification): NotificationSettingsImpl {
        notificationSettings.setPublicVersion(notification)
        return this
    }

    override fun setStyle(style: NotificationCompat.Style): NotificationSettingsImpl {
        notificationSettings.setStyle(style)
        return this
    }

    override fun takeBuilder(): NotificationCompat.Builder {
        return notificationSettings.takeBuilder()
    }

    override fun build(): Notification {
        return notificationSettings.build()
    }

    override fun show(notificationId: Int, notification: Notification?) {
        notificationSettings.show(notificationId, notification)
    }

}