package com.skfo763.bunny_notifier.model

import android.app.PendingIntent
import androidx.annotation.DrawableRes
import com.skfo763.bunny_notifier.R
import com.skfo763.bunny_notifier.core.DEFAULT_GROUP_CHANNEL_ID
import com.skfo763.bunny_notifier.core.DEFAULT_GROUP_CHANNEL_NAME
import com.skfo763.bunny_notifier.core.DEFAULT_GROUP_ID

class GroupNotification {
    var groupId = DEFAULT_GROUP_ID
    @DrawableRes var smallIconForSystem = R.drawable.ic_bunny_icon
    var groupChannel = NotifierChannel(DEFAULT_GROUP_CHANNEL_ID, DEFAULT_GROUP_CHANNEL_NAME)
    var groupClickIntent: PendingIntent? = null
}