package com.skfo763.bunny_notifier.model

import android.graphics.Bitmap
import androidx.annotation.DrawableRes

class BaseNotification(
    val title: String,
    val text: String?,
    @DrawableRes val smallIconResId: Int,
    val largeIcon: Bitmap?
) {
    constructor(title: String, text: String?, @DrawableRes smallIconResId: Int) :
            this(title, text, smallIconResId, null)
}