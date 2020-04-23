package com.skfo763.bunny_notifier.model

import android.widget.RemoteViews
import androidx.annotation.DrawableRes

class CustomNotification(
    val titleForSystem: String,
    val textForSystem: String?,
    @field:DrawableRes @param:DrawableRes val smallIconForSystem: Int,
    val remoteViews: RemoteViews
)