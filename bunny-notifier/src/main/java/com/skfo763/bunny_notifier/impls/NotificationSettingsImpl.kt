package com.skfo763.bunny_notifier.impls

import android.annotation.TargetApi
import android.app.Notification
import android.app.PendingIntent
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.core.app.NotificationCompat
import com.skfo763.bunny_notifier.model.NotifierChannel

interface NotificationSettingsImpl: ShowImpl, BuildImpl {

    /**
     *  When you need to group the push notifications, use this method/
     *  @param groupSmallIconResId : small icon which exposes at grouped states of multiple notification.
     *  @param groupId : groupId which should be unique along with different notification group.
     *  @param groupChannel : If you want to set separate notification channel of group, use this param.
     *  @return The same Builder.
     */
    @TargetApi(24)
    fun setGroup(
        @DrawableRes groupSmallIconResId: Int,
        groupId: String,
        groupChannel: NotifierChannel? = null
    ): NotificationSettingsImpl


    /**
     * Group Click Event - with PendingIntent
     * @param clickIntent : PendingIntent of click action
     * @return The same Builder.
     */
    @TargetApi(24)
    fun setGroupClickIntent(clickIntent: PendingIntent): NotificationSettingsImpl


    /**
     * Set the time that event occured. Notification in the pannel are sorted by this time.
     * @param whenTimeMillis : Long millisecond time
     * @return The same Builder.
     */
    @TargetApi(24)
    fun setWhen(whenTimeMillis: Long): NotificationSettingsImpl


    /**
     * Set this flag if you would only like the sound, vibrate
     * and ticker to be played if the notification is not already showing.
     * @param isOnlyAlertOnce : boolean flag value
     * @return The same Builder.
     */
    @TargetApi(24)
    fun setOnlyAlertOnce(isOnlyAlertOnce: Boolean): NotificationSettingsImpl


    /**
     * Set this flag true if you want to keep notification on after push is clicked.
     * @param autoCancel : boolean flag value
     * @return The same Builder.
     */
    @TargetApi(24)
    fun setAutoCancel(autoCancel: Boolean): NotificationSettingsImpl


    /**
     * Push Click Action - with PendingIntent
     * @param clickAction : PendingIntent of click action
     * @return The same Builder.
     */
    @TargetApi(24)
    fun setClickAction(clickAction: PendingIntent): NotificationSettingsImpl


    /**
     * The accent color to use
     * @param color : 16digit Color Int
     * @return The same Builder.
     */
    @TargetApi(21)
    fun setColor(@ColorInt color: Int): NotificationSettingsImpl


    /**
     * Supply a replacement Notification whose contents should be shown in insecure contexts
     * @param notification A replacement notification, presumably with some or all info redacted.
     * @return The same Builder.
     */
    @TargetApi(21)
    fun setPublicVersion(notification: Notification): NotificationSettingsImpl

    /**
     * Set Notification Style for BigText and others
     * @param style Notification style: ex) NotificationCompat.BigTextStyle()
     * @return The same Builder.
     */
    fun setStyle(style: NotificationCompat.Style): NotificationSettingsImpl

}