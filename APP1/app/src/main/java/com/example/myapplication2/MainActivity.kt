//package com.example.myapplication2
//
//import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.myapplication1.R
//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//    }
//}

package com.example.scroolview

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication1.R

//
//class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContentView(R.layout.activity_main)
//
//    }
//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu1,menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return when(item.itemId){
//            R.id.search->{
//                Toast.makeText(this,"Search is clicked",Toast.LENGTH_LONG).show()
//                true
//            }
//            R.id.share->{
//                Toast.makeText(this,"share is clicked",Toast.LENGTH_LONG).show()
//                true
//            }
//            R.id.Facebook->{
//                Toast.makeText(this,"Facebook is clicked",Toast.LENGTH_LONG).show()
//                true
//            }
//
//
//            else ->super.onOptionsItemSelected(item)
//
//
//        }
//    }
//
//
//}



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toastButton=findViewById<Button>(R.id.button_toast)
//        toastButton.setOnClickListener{
////            showToast()
//        }

//        val ratingBar=findViewById<RatingBar>(R.id.rating_bar)
//        val t=findViewById<TextView>(R.id.textView)
//        val button=findViewById<Button>(R.id.submit_rating)
//        ratingBar.setOnRatingBarChangeListener{rBar, fl, b->
//            button.text=fl.toString()
//            when(rBar.rating.toInt()){
//                1->button.text="very bad☹️"
//                2->button.text="bad☹️"
//                3->button.text="Good️🙂"
//                4->button.text="very Good😀️"
//                5->button.text="very very Good😆️"
//
//
//
//
//            }

        val ratingBar = findViewById<RatingBar>(R.id.rating_bar)
        val textView = findViewById<TextView>(R.id.textview) // TextView to show message
        val button = findViewById<Button>(R.id.submit_rating)

        button.setOnClickListener {
            val rating = ratingBar.rating.toInt()
            textView.text = when (rating) {
                1 -> "Very Bad ☹️"
                2 -> "Bad ☹️"
                3 -> "Good 🙂"
                4 -> "Very Good 😀"
                5 -> "Excellent 😆"
                else -> "Please select a rating"
            }
        }

        }
    }

//    private fun showToast() {
//        val inflater: LayoutInflater = LayoutInflater.from(this)
//        val view: View =inflater.inflate(R.layout.item_toast,findViewById(R.id.toastRoot))
//        val toast:Toast=Toast(this)
//        toast.setGravity(Gravity.BOTTOM or Gravity.FILL_HORIZONTAL,0,0)
//        toast.duration=Toast.LENGTH_LONG
//        toast.view=view
//        toast.show()
//    }
