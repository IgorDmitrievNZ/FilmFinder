package com.example.android.filmfinder.services

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

private const val CUSTOM_FIELD = "custom"
private const val TAG = "Pushes"

class MessagingService : FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.i("token", token)

    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val custom = message.data[CUSTOM_FIELD]
        Log.i(TAG, custom ?: "no data!")
    }


}