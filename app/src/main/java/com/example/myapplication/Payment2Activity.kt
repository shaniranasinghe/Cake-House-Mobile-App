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

class Payment2Activity : AppCompatActivity() {
    //@SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.payment2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val pay=findViewById<Button>(R.id.pay_now_button)
        pay.setOnClickListener {
            val Intent = Intent(this, ThankyouActivity::class.java)
            startActivity(Intent)
        }

//        val Home3=findViewById<ImageView>(R.id.home)
//        Home3.setOnClickListener {
//            val Intent = Intent(this, HomeActivity::class.java)
//            startActivity(Intent)
//        }
//
//        val Profile3=findViewById<ImageView>(R.id.profile)
//        Profile3.setOnClickListener {
//            val Intent = Intent(this, ProfileActivity::class.java)
//            startActivity(Intent)
//        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }


    }
}