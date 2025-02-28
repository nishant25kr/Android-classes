package com.example.myapplication1

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toastButton=findViewById<Button>(R.id.button_toast)
        toastButton.setOnClickListener{
            showToast()
        }
        //rating bar
        val ratingBar = findViewById<RatingBar>(R.id.rating_bar)
        val textView = findViewById<TextView>(R.id.textview) // TextView to show message
        val button = findViewById<Button>(R.id.submit_rating)

        button.setOnClickListener {
            val progressBar1=findViewById<ProgressBar>(R.id.progressBar1)
            progressBar1.max=1000
            val rating = ratingBar.rating.toInt()
//            val currentProgress1=rating
            ObjectAnimator.ofInt(progressBar1,"Progress",rating*200)
                .setDuration(500)
                .start()
            textView.text = when (rating) {
                1 -> "Very Bad ☹️"
                2 -> "Bad ☹️"
                3 -> "Good 🙂"
                4 -> "Very Good 😀"
                5 -> "Excellent 😆"
                else -> "Please select a rating"
            }
        }

        //progress bar
        val progressBar=findViewById<ProgressBar>(R.id.progressBar)
        progressBar.max=1000
        val currentProgress=800
        ObjectAnimator.ofInt(progressBar,"Progress",currentProgress)
            .setDuration(1500)
            .start()
    }

    private fun showToast() {
        val inflater:LayoutInflater=LayoutInflater.from(this)
        val view:View=inflater.inflate(R.layout.item_toast,findViewById(R.id.toastRoot))
        val toast:Toast=Toast(this)
        toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL,0,0)
        toast.duration=Toast.LENGTH_LONG
        toast.view=view
        toast.show()
    }
}