package com.skfo763.bunny_notifier.core

import android.annotation.TargetApi
import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import android.widget.RemoteViews
import androidx.annotation.DrawableRes
import com.skfo763.bunny_notifier.impls.NotificationSettingsImpl
import com.skfo763.bunny_notifier.impls.ShowImpl
import com.skfo763.bunny_notifier.model.BaseNotification
import com.skfo763.bunny_notifier.model.GroupNotification
import com.skfo763.bunny_notifier.model.NotifierChannel

open class NotifierContextProcessor (
    private val context: Context,
    private val channel: NotifierChannel
): NotificationSettings(context, channel) {

    private lateinit var groupNotification: GroupNotification
    override fun setGroup(groupCount: Int, groupSmallIconResId: Int, groupId: String) {
        TODO("Not yet implemented")
    }

    override fun setGroupChannel(groupChannel: NotifierChannel) {
        TODO("Not yet implemented")
    }

    override fun setGroupClickIntent(clickIntent: PendingIntent) {
        TODO("Not yet implemented")
    }

    override fun setAutoCancel(autoCancel: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setBase(notifierBase: BaseNotification) {
        TODO("Not yet implemented")
    }

    override fun setCustom(remoteViews: RemoteViews) {
        TODO("Not yet implemented")
    }

    override fun setClickAction(clickAction: PendingIntent) {
        TODO("Not yet implemented")
    }

    override fun setOnlyAlertOnce(isOnlyAlertOnce: Boolean) {
        TODO("Not yet implemented")
    }

    override fun setWhen(`when`: Long) {
        TODO("Not yet implemented")
    }

    override fun build(): Notification {
        TODO("Not yet implemented")
    }

    override fun setColor(color: Int) {
        TODO("Not yet implemented")
    }

    override fun setPublicVersion(notification: Notification) {
        TODO("Not yet implemented")
    }

    override fun show(notificationId: Int) {
        TODO("Not yet implemented")
    }
}