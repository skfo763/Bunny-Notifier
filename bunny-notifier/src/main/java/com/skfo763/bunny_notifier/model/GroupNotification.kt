package com.skfo763.bunny_notifier.model

import android.app.PendingIntent
import androidx.annotation.DrawableRes

class GroupNotification(
    val groupId: String,
    @DrawableRes val smallIconForSystem: Int,
    val groupChannel: NotifierChannel?,
    var groupClickIntent: PendingIntent?
) {
    constructor(groupId: String, @DrawableRes smallIconForSystem: Int):
            this(groupId, smallIconForSystem, null, null)

    constructor(groupId: String, @DrawableRes smallIconForSystem: Int, channel: NotifierChannel?):
            this(groupId, smallIconForSystem, channel, null)
}