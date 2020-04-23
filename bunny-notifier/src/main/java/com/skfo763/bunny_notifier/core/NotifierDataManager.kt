package com.skfo763.bunny_notifier.core

import android.app.Notification
import android.app.PendingIntent
import com.skfo763.bunny_notifier.impls.BaseImpl
import com.skfo763.bunny_notifier.impls.NotificationSettingsImpl
import com.skfo763.bunny_notifier.model.BaseNotification
import com.skfo763.bunny_notifier.model.CustomNotification
import com.skfo763.bunny_notifier.model.NotifierChannel

class NotifierDataManager(
    private val processor: NotificationSettings
): BaseImpl, NotificationSettingsImpl {
    override fun setBase(baseData: BaseNotification): NotificationSettingsImpl {

    }

    override fun setCustom(customNotification: CustomNotification): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setGroup(
        groupSmallIconResId: Int,
        groupId: String,
        groupChannel: NotifierChannel?
    ): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setGroupClickIntent(clickIntent: PendingIntent): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setWhen(whenTimeMillis: Long): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setOnlyAlertOnce(isOnlyAlertOnce: Boolean): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setAutoCancel(autoCancel: Boolean): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setClickAction(clickAction: PendingIntent): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setColor(color: Int): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun setPublicVersion(notification: Notification): NotificationSettingsImpl {
        TODO("Not yet implemented")
    }

    override fun show(notificationId: Int) {
        TODO("Not yet implemented")
    }

    override fun build(): Notification {
        TODO("Not yet implemented")
    }

}