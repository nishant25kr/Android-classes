package com.example.customisedbutton

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var textid = findViewById<TextView>(R.id.textView)
        var button1 = findViewById<Button>(R.id.button)
        var color = setTheme
        button1.setOnClickListener{
            textid.background=

        }
    }
}