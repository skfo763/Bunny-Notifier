package com.skfo763.bunny_notifier.impls

import com.skfo763.bunny_notifier.model.BaseNotification
import com.skfo763.bunny_notifier.model.CustomNotification

interface BaseImpl {
    fun setBase(baseData: BaseNotification): NotificationSettingsImpl
    fun setCustom(customNotification: CustomNotification): NotificationSettingsImpl
}