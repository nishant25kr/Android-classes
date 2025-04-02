package com.example.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        val btnToast: Button = findViewById(R.id.btnToast)
        val btnReminder: Button = findViewById(R.id.btnReminder)

        // Custom Toast
        btnToast.setOnClickListener {
            val inflater = layoutInflater
            val layout = inflater.inflate(R.layout.custom_toast, null)
            val text = layout.findViewById<TextView>(R.id.toastText)
            text.text = "Task Added!"

            val toast = Toast(applicationContext)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = layout
            toast.show()
        }

        // Set Alarm for Reminder
        btnReminder.setOnClickListener {
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MINUTE, 1)

            val intent = Intent(this, AlarmReceiver::class.java)
            val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, pendingIntent)

            Toast.makeText(this, "Reminder Set!", Toast.LENGTH_SHORT).show()
        }
    }
}