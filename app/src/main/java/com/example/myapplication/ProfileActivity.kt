package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity() {
    //@SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val logout=findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            val Intent = Intent(this, LoginActivity::class.java)
            startActivity(Intent)
        }

        val menu=findViewById<ImageView>(R.id.menu)
        menu.setOnClickListener {
            val Intent = Intent(this, EditprofileActivity::class.java)
            startActivity(Intent)
        }

        //val name = findViewById<TextView>(R.id.username)
        //val email = findViewById<TextView>(R.id.email_address)
        //val password = findViewById<TextView>(R.id.password)
        //val phone = findViewById<TextView>(R.id.phoneno)

        //name.text = intent.getStringExtra("name")!!
        //email.text = intent.getStringExtra("email")!!
        //password.text = intent.getStringExtra("password")!!
        //phone.text = intent.getStringExtra("phone")!!






    }
}