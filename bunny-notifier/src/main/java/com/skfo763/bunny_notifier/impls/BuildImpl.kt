package com.skfo763.bunny_notifier.impls

import android.app.Notification
import androidx.core.app.NotificationCompat

interface BuildImpl {
    fun build(): Notification
}