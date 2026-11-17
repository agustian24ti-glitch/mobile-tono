package com.example.mobile_tono.Note

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile_tono.databinding.ActivityNoteBinding
import kotlinx.coroutines.launch

class NoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoteBinding
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        loadNotes()

        binding.btnAdd.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val content = binding.etContent.text.toString().trim()

            if (title.isNotEmpty() && content.isNotEmpty()) {
                addNote(title, content)
            } else {
                Toast.makeText(this, "Judul & isi wajib diisi", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setupRecyclerView() {
        noteAdapter = NoteAdapter(
            notes = emptyList(),
            onDoneClick = { note -> updateNoteStatus(note) },
            onDeleteClick = { note -> deleteNote(note) }
        )
        binding.rvNotes.layoutManager = LinearLayoutManager(this)
        binding.rvNotes.adapter = noteAdapter
    }

    private fun loadNotes() {
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.api.getNotes(RetrofitClient.API_KEY)
                if (response.isSuccessful) {
                    noteAdapter.updateData(response.body() ?: emptyList())
                } else {
                    Toast.makeText(this@NoteActivity, "Gagal memuat data: ${response.code()}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@NoteActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun addNote(title: String, content: String) {
        lifecycleScope.launch {
            try {
                val newNote = Note(title = title, content = content, status = "To Do")
                val response = RetrofitClient.api.createNote(RetrofitClient.API_KEY, newNote)
                if (response.isSuccessful) {
                    binding.etTitle.text.clear()
                    binding.etContent.text.clear()
                    Toast.makeText(this@NoteActivity, "Catatan ditambahkan!", Toast.LENGTH_SHORT).show()
                    loadNotes()
                }
            } catch (e: Exception) {
                Toast.makeText(this@NoteActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun updateNoteStatus(note: Note) {
        val id = note.id ?: return
        lifecycleScope.launch {
            try {
                val updated = note.copy(status = "Done")
                val response = RetrofitClient.api.updateNote(RetrofitClient.API_KEY, "eq.$id", updated)
                if (response.isSuccessful) {
                    Toast.makeText(this@NoteActivity, "Status diubah ke Done", Toast.LENGTH_SHORT).show()
                    loadNotes()
                }
            } catch (e: Exception) {
                Toast.makeText(this@NoteActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun deleteNote(note: Note) {
        val id = note.id ?: return
        lifecycleScope.launch {
            try {
                val response = RetrofitClient.api.deleteNote(RetrofitClient.API_KEY, "eq.$id")
                if (response.isSuccessful) {
                    Toast.makeText(this@NoteActivity, "Catatan dihapus", Toast.LENGTH_SHORT).show()
                    loadNotes()
                }
            } catch (e: Exception) {
                Toast.makeText(this@NoteActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}