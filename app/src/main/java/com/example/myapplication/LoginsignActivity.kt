package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginsignActivity : AppCompatActivity() {

    lateinit var btnLogin1 : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.loginsign)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnLogin1 = findViewById(R.id.btnLogin)

        btnLogin1.setOnClickListener{
            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
        }

//        val btnLogin1: Button=findViewById(R.id.btnLogin)
//        btnLogin1.setOnClickListener {
//            val Intent = Intent(this, LoginActivity::class.java)
//            startActivity(Intent)
//        }

        val btnSignUp1=findViewById<Button>(R.id.btnSignUp)
        btnSignUp1.setOnClickListener {
            val Intent = Intent(this, SignupActivity::class.java)
            startActivity(Intent)
        }

        val continueAsGuest=findViewById<TextView>(R.id.continueAsGuest)
        continueAsGuest.setOnClickListener {
            val Intent = Intent(this, HomeActivity::class.java)
            startActivity(Intent)
        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }


    }
}