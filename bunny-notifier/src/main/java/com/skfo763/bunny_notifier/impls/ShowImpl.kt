package com.skfo763.bunny_notifier.impls

import android.app.Notification
import androidx.core.app.NotificationCompat

interface ShowImpl {
    fun takeBuilder(): NotificationCompat.Builder
    fun show(notificationId: Int, notification: Notification? = null)
}