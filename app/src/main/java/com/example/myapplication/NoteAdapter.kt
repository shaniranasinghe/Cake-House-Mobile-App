package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(
    private val context: Context,
    private val notes: MutableList<String>,
    private val onDelete: (String) -> Unit,
    private val onEdit: (String, Int) -> Unit // Add edit click listener with note and its position
) : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val noteTextView: TextView = itemView.findViewById(R.id.noteTextView)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)
        val editButton: ImageView = itemView.findViewById(R.id.editButton)

        fun bind(note: String, position: Int) {
            noteTextView.text = note

            // Handle delete button click
            deleteButton.setOnClickListener {
                onDelete(note)
            }

            // Handle edit button click
            editButton.setOnClickListener {
                onEdit(note, position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(notes[position], position)
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}

