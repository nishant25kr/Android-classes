package com.example.myapplication1

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Initialize BottomNavigationView
        bottomNavigationView = findViewById(R.id.bottom_navigation_bar)

        // Set Default Fragment
        replaceFragment(Home1())

        // Bottom Navigation Listener
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> replaceFragment(Home1())
                R.id.location -> replaceFragment(Location1())
                R.id.call -> replaceFragment(Call1())
            }
            true // Ensure listener works correctly
        }

        // Initialize and Set OnClickListener for Toast Button
        val toastButton = findViewById<Button>(R.id.button_toast)
        toastButton?.setOnClickListener {
            showToast()
        }

        // Rating Bar Setup
        val ratingBar = findViewById<RatingBar>(R.id.rating_bar)
        val textView = findViewById<TextView>(R.id.textview)
        val button = findViewById<Button>(R.id.submit_rating)

        button?.setOnClickListener {
            val progressBar1 = findViewById<ProgressBar>(R.id.progressBar1)
            progressBar1?.max = 1000
            val rating = ratingBar?.rating?.toInt() ?: 0

            ObjectAnimator.ofInt(progressBar1, "progress", rating * 200)
                .setDuration(500)
                .start()

            textView?.text = when (rating) {
                1 -> "Very Bad ☹️"
                2 -> "Bad ☹️"
                3 -> "Good 🙂"
                4 -> "Very Good 😀"
                5 -> "Excellent 😆"
                else -> "Please select a rating"
            }
        }

        // Progress Bar Animation
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        progressBar?.max = 1000
        val currentProgress = 800
        ObjectAnimator.ofInt(progressBar, "progress", currentProgress)
            .setDuration(1500)
            .start()
    }

    // Function to Replace Fragments
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameLayout, fragment)
            .commit()
    }

    // Custom Toast Function
    private fun showToast() {
        val inflater: LayoutInflater = LayoutInflater.from(this)
        val view: View? = inflater.inflate(R.layout.item_toast, findViewById(R.id.toastRoot), false)

        if (view != null) {
            val toast = Toast(this)
            toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL, 0, 0)
            toast.duration = Toast.LENGTH_LONG
            toast.view = view
            toast.show()
        } else {
            Toast.makeText(this, "Error: Custom toast layout not found", Toast.LENGTH_SHORT).show()
        }
    }
}
