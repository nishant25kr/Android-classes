package com.example.myapplication1

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toastButton=findViewById<Button>(R.id.button_toast)
        toastButton.setOnClickListener{
            showToast()
        }
    }

    private fun showToast() {
        val inflater: LayoutInflater = LayoutInflater.from(this)
        val view: View =inflater.inflate(R.layout.item_toast,findViewById(R.id.toastRoot))
        val toast: Toast = Toast(this)
        toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL,0,0)
        toast.duration= Toast.LENGTH_LONG
        toast.view=view
        toast.show()
    }
}