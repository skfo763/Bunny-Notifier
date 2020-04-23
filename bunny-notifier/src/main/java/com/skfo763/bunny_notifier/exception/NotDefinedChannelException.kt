package com.skfo763.bunny_notifier.exception

class NotDefinedChannelException: Exception(message) {
    companion object {
        const val message = "Channel have to be defined before building notification"
    }
}