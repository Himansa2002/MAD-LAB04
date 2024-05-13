package com.example.notesapp.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.Note
import com.example.notesapp.NoteDatabaseHelper

class NotesAdapterViewModel(context: Context) : ViewModel() {
    private val _notes = MutableLiveData<List<Note>>()
    val notes: LiveData<List<Note>> = _notes

    private val db: NoteDatabaseHelper = NoteDatabaseHelper(context)

    fun loadNotes() {
        _notes.value = db.getAllNotes()
    }

    fun deleteNoteById(noteId: Int) {
        db.deleteNote(noteId)
        loadNotes()
    }
}
