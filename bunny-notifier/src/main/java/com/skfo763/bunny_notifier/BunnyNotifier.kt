package com.skfo763.bunny_notifier

import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.skfo763.bunny_notifier.core.NotifierContextProcessor
import com.skfo763.bunny_notifier.core.NotifierDataManager
import com.skfo763.bunny_notifier.impls.BaseImpl
import com.skfo763.bunny_notifier.model.NotifierChannel

class BunnyNotifier private constructor() {

    private object Holder {
        val INSTANCE = BunnyNotifier()
    }

    companion object {
        val i: BunnyNotifier by lazy { Holder.INSTANCE }
    }

    /**
     * register channel at device over Api 26(Oreo)
     */
    @RequiresApi(26)
    private fun registerChannel(context: Context, channel: NotifierChannel) {
        context.getSystemService(NotificationManager::class.java)
            ?.createNotificationChannel(NotifierChannel.convertToNotificationChannel(channel))
    }

    /**
     * deregister channel at device over Api 26(Oreo)
     */
    @RequiresApi(26)
    private fun deleteChannel(context: Context, channelId: String) {
        val manager = context.getSystemService(NotificationManager::class.java) ?: return
        val notificationChannel = manager.getNotificationChannel(channelId)
        if (notificationChannel != null) {
            manager.deleteNotificationChannel(channelId)
        }
    }


    /**
     * initialize notification builder
     * @param context
     */
    fun with(context: Context, channel: NotifierChannel) : BaseImpl {
        if (Build.VERSION.SDK_INT >= 26) {
            registerChannel(context, channel)
        }
        return NotifierDataManager(NotifierContextProcessor(context, channel))
    }
}