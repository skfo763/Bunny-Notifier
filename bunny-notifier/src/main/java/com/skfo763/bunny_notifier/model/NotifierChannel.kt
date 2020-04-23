package com.skfo763.bunny_notifier.model

import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.graphics.Color
import android.media.AudioAttributes
import android.net.Uri
import android.os.Build
import android.provider.Settings
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi

class NotifierChannel(val channelId: String, val channelName: CharSequence) {

    companion object {
        private val DEFAULT_SOUND = Settings.System.DEFAULT_NOTIFICATION_URI
        private val DEFAULT_VIBRATE_PATTERN = longArrayOf(0, 250, 250, 250)
        private const val DEFAULT_COLOR = Color.TRANSPARENT

        @RequiresApi(26)
        fun convertToChannel(channel: NotificationChannel) =
            NotifierChannel(channel.id, channel.name).apply {
                description = channel.description
                isEnableVibration = channel.shouldVibrate()
                isEnableShowLights = channel.shouldShowLights()
                channel.sound?.let { this.sound = it }
                vibrationPattern = channel.vibrationPattern
                lightColor = channel.lightColor
                lockScreenVisibility = channel.lockscreenVisibility
                importance = channel.importance
                isShowBadge = channel.canShowBadge()
            }
        
        @RequiresApi(26)
        fun convertToNotificationChannel(channel: NotifierChannel): NotificationChannel =
            NotificationChannel(channel.channelId, channel.channelName, channel.importance).apply { 
                channel.description?.let { description = it }
                lockscreenVisibility = channel.lockScreenVisibility
                
                setSound(if(channel.isEnableSound) channel.sound else null,
                    AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_NOTIFICATION_RINGTONE)
                        .build())
                
                enableVibration(channel.isEnableVibration)
                if(channel.isEnableVibration) {
                    vibrationPattern = channel.vibrationPattern
                }
                enableLights(channel.isEnableShowLights)
                if(channel.isEnableShowLights) {
                    lightColor = channel.lightColor
                }
                setShowBadge(channel.isShowBadge)
            }
    }

    var description: String? = null
    var sound: Uri = DEFAULT_SOUND
    var vibrationPattern = DEFAULT_VIBRATE_PATTERN

    @get:TargetApi(16)
    var importance = if (Build.VERSION.SDK_INT >= 24) NotificationManager.IMPORTANCE_DEFAULT else 3
    var isEnableVibration = false
    var isEnableSound = false
    var isEnableShowLights = false
    var isShowBadge = false

    @ColorInt var lightColor = DEFAULT_COLOR
    
    @get:TargetApi(21)
    @TargetApi(21)
    var lockScreenVisibility = Notification.VISIBILITY_PUBLIC
}