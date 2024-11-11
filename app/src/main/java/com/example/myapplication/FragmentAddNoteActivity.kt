package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FragmentAddNoteActivity : AppCompatActivity() {

    private lateinit var addNoteTitle: EditText
    private lateinit var addNoteDesc: EditText
    private lateinit var saveNoteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add_note)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Initialize views
        addNoteTitle = findViewById(R.id.addNoteTitle)
        addNoteDesc = findViewById(R.id.addNoteDesc)
        saveNoteButton = findViewById(R.id.saveNoteButton)

        // Set the click listener for the save button
        saveNoteButton.setOnClickListener {
            if (addNoteTitle.text.isNotEmpty() && addNoteDesc.text.isNotEmpty()) {
                saveNoteData()  // Save data when button is clicked
                // Show Toast message after successful save
                Toast.makeText(this, "You have successfully saved", Toast.LENGTH_SHORT).show()
                addNoteTitle.text.clear()
                addNoteDesc.text.clear()
            } else {
                // Show Toast message if fields are empty
                Toast.makeText(this, "Please fill out both fields", Toast.LENGTH_SHORT).show()
            }

            val note1=findViewById<Button>(R.id.saveNoteButton)
            note1.setOnClickListener {
                val Intent = Intent(this, NotelistActivity::class.java)
                startActivity(Intent)
            }

            val back: ImageView = findViewById(R.id.ivBack)
            back.setOnClickListener {
                @Suppress("DEPRECATION")
                onBackPressed()  // Navigate to the previous screen
            }

        }
    }

    private fun saveNoteData() {
        // Get the text from the EditText fields
        val title = addNoteTitle.text.toString()
        val description = addNoteDesc.text.toString()

        // Combine title and description
        val note = "$title: $description"

        // Use SharedPreferences to store the title and description
        val sharedPreferences = getSharedPreferences("NotePreferences", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        // Retrieve existing notes
        val notesSet = sharedPreferences.getStringSet("notes", mutableSetOf()) ?: mutableSetOf()
        notesSet.add(note) // Add the new note to the set

        // Save the entered title and description in SharedPreferences
        editor.putStringSet("notes", notesSet)
        editor.apply()  // Commit the changes

        // Optionally, show a message to confirm the data is saved
        // Toast.makeText(this, "Note saved successfully!", Toast.LENGTH_SHORT).show()
    }
}
