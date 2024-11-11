package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NotelistActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private var notes: MutableList<String> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.notelist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val back: ImageView = findViewById(R.id.ivBack)
        back.setOnClickListener {
            @Suppress("DEPRECATION")
            onBackPressed()  // Navigate to the previous screen
        }

        val add = findViewById<FloatingActionButton>(R.id.addNoteFab)
        add.setOnClickListener {
            val Intent = Intent(this, FragmentAddNoteActivity::class.java)
            startActivity(Intent)
        }

        val view=findViewById<Button>(R.id.conti)
        view.setOnClickListener {
            val Intent = Intent(this, MainActivity1::class.java)
            startActivity(Intent)
        }

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.notesRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Load stored notes
        sharedPreferences = getSharedPreferences("NotePreferences", Context.MODE_PRIVATE)
        loadNotes()

        // Set up adapter with delete and edit actions
        adapter = NoteAdapter(this, notes, { note -> deleteNote(note) }, { note, position -> editNoteDialog(note, position) })
        recyclerView.adapter = adapter


    }

    // Load notes from SharedPreferences
    private fun loadNotes() {
        val notesSet = sharedPreferences.getStringSet("notes", null) ?: emptySet()
        notes.clear()
        notes.addAll(notesSet)
//        adapter.notifyDataSetChanged()
    }

    // Edit note dialog
    private fun editNoteDialog(note: String, position: Int) {
        val dialogView = LayoutInflater.from(this).inflate(R.layout.dialog_edit_note, null)
        val editTitle = dialogView.findViewById<EditText>(R.id.editNoteTitle)
        val editDesc = dialogView.findViewById<EditText>(R.id.editNoteDesc)

        // Pre-fill with current note details
        val parts = note.split(": ")
        editTitle.setText(parts[0])
        editDesc.setText(parts[1])

        val dialog = AlertDialog.Builder(this)
            .setTitle("Edit Note")
            .setView(dialogView)
            .setPositiveButton("Save") { _, _ ->
                val newTitle = editTitle.text.toString()
                val newDesc = editDesc.text.toString()
                val updatedNote = "$newTitle: $newDesc"

                // Update note in the list and notify the adapter
                notes[position] = updatedNote
                saveNotes()
                adapter.notifyDataSetChanged() // Refresh RecyclerView
                Toast.makeText(this, "Note updated", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    // Delete a specific note
    private fun deleteNote(note: String) {
        notes.remove(note)
        saveNotes()
        adapter.notifyDataSetChanged()  // Notify adapter that data has changed
        Toast.makeText(this, "Note deleted", Toast.LENGTH_SHORT).show()
    }

    // Save updated notes back to SharedPreferences
    private fun saveNotes() {
        val editor = sharedPreferences.edit()
        editor.putStringSet("notes", notes.toSet())
        editor.apply()
    }


//    private fun displayAllNotes() {
//        // Access SharedPreferences to retrieve the stored notes
//        val sharedPreferences = getSharedPreferences("NotePreferences", Context.MODE_PRIVATE)
//
//        // Get the set of notes
//        val notesSet = sharedPreferences.getStringSet("notes", null) ?: setOf()
//
//        // Join the notes into a single string for display
//        val allNotes = notesSet.joinToString("\n") // Separate notes by new lines
//
//        // Set the notes to the TextView
//        notesTextView.text = if (allNotes.isNotEmpty()) allNotes else "No notes available."
//    }
}