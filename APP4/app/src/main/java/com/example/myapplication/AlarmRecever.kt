package com.example.myapplication

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val i = Intent(context,DestinationActivity::class.java)
        intent!!.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        val pendingIntent=PendingIntent.getActivity(context,0,i,0)
        val builder=NotificationCompat.Builder(context!!,"android1")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Alarm Manager")
            .setContentTitle("This is a Alarm Manager")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.DEFAULT_ALL)
            .setContentIntent(pendingIntent)
        
        val notificationManager=NotificationManagerCompat.from(context)
        notificationManager.notify(123,builder.build())


        }
}