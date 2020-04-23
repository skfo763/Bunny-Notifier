package com.skfo763.bunny_notifier.model

import android.app.Notification
import android.app.NotificationManager
import android.os.Build

object NotifierImportance {
    val IMPORTANCE_MIN =
        if (Build.VERSION.SDK_INT >= 26) NotificationManager.IMPORTANCE_MIN
        else if (Build.VERSION.SDK_INT >= 16) {
            Notification.PRIORITY_LOW
        } else -1

    val IMPORTANCE_LOW =
        if (Build.VERSION.SDK_INT >= 26) NotificationManager.IMPORTANCE_LOW
        else if (Build.VERSION.SDK_INT >= 16) Notification.PRIORITY_LOW
        else -1

    val IMPORTANCE_DEFAULT =
        if (Build.VERSION.SDK_INT >= 26) NotificationManager.IMPORTANCE_DEFAULT
        else if (Build.VERSION.SDK_INT >= 16) Notification.PRIORITY_DEFAULT
        else 0

    val IMPORTANCE_HIGH =
        if (Build.VERSION.SDK_INT >= 26) NotificationManager.IMPORTANCE_HIGH
        else if (Build.VERSION.SDK_INT >= 16) Notification.PRIORITY_HIGH
        else 1

    val IMPORTANCE_MAX =
        if (Build.VERSION.SDK_INT >= 26) NotificationManager.IMPORTANCE_HIGH
        else if (Build.VERSION.SDK_INT >= 16) Notification.PRIORITY_MAX
        else 2
}

object NotifierVisibility {
    val VISIBILITY_PUBLIC =
        if (Build.VERSION.SDK_INT >= 21) Notification.VISIBILITY_PUBLIC else 1
    val VISIBILITY_PRIVATE =
        if (Build.VERSION.SDK_INT >= 21) Notification.VISIBILITY_PRIVATE else 0
    val VISIBILITY_SECRET =
        if (Build.VERSION.SDK_INT >= 21) Notification.VISIBILITY_SECRET else -1
}