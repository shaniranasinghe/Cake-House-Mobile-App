package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PaymentActivity : AppCompatActivity() {
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pay=findViewById<Button>(R.id.conti)
        pay.setOnClickListener {
            val Intent = Intent(this, TimerActivity::class.java)
            startActivity(Intent)
        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }

//        val Home2=findViewById<ImageView>(R.id.home)
//        Home2.setOnClickListener {
//            val Intent = Intent(this, HomeActivity::class.java)
//            startActivity(Intent)
//        }
//
//        val Profile2=findViewById<ImageView>(R.id.profile)
//        Profile2.setOnClickListener {
//            val Intent = Intent(this, ProfileActivity::class.java)
//            startActivity(Intent)
//        }


    }
}