package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Onboarding03Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.onboarding03)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnGetStarted=findViewById<Button>(R.id.buttn)
        btnGetStarted.setOnClickListener {
            val Intent = Intent(this, LoginsignActivity::class.java)
            startActivity(Intent)
        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }

    }
}