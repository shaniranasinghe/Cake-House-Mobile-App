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

class ContentActivity : AppCompatActivity() {
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.content)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val Home1=findViewById<ImageView>(R.id.home)
        Home1.setOnClickListener {
            val Intent = Intent(this, HomeActivity::class.java)
            startActivity(Intent)
        }

        val note=findViewById<ImageView>(R.id.favourite)
        note.setOnClickListener {
            val Intent = Intent(this, NotelistActivity::class.java)
            startActivity(Intent)
        }

        val view1=findViewById<Button>(R.id.addExtra)
        view1.setOnClickListener {
            val Intent = Intent(this, NotelistActivity::class.java)
            startActivity(Intent)
        }


        val note1=findViewById<ImageView>(R.id.category)
        note1.setOnClickListener {
            val Intent = Intent(this, VideoPreviewActivity::class.java)
            startActivity(Intent)
        }

        val Profile1=findViewById<ImageView>(R.id.profile)
        Profile1.setOnClickListener {
            val Intent = Intent(this, ProfileActivity::class.java)
            startActivity(Intent)
        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }

        val view=findViewById<Button>(R.id.conti)
        view.setOnClickListener {
            val Intent = Intent(this, MainActivity1::class.java)
            startActivity(Intent)
        }


    }
}