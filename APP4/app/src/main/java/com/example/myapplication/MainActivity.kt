package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val exbut = findViewById<Button>(R.id.button)
        exbut.setOnClickListener{
            val exInt = Intent(this,second::class.java)
            startActivity(exInt)
            finish()
        }

        val uri = "https://www.google.com"
        val exbut = findViewById<Button>(R.id.)


    }
}