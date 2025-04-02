package com.example.myapplication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmReceiver: BroadcastReceiver()  {
    override fun onReceive(context: Context, intent: Intent?) {
        Toast.makeText(context, "Reminder Triggered!", Toast.LENGTH_LONG).show()
        NotificationHelper.showNotification(context, "Reminder", "Time for your task!")
    }

}
