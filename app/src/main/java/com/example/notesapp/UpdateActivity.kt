package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notesapp.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {


    private lateinit var binding : ActivityUpdateBinding
    private lateinit var db : NoteDatabaseHelper
    private  var noteId : Int = -1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        db = NoteDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)

        if(noteId==-1){

            finish()
            return
        }

        val note = db.getNoteBYID(noteId)
        binding.titleUpdateEditText.setText(note.title)
         binding.contentUpdateEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener{

            val newTitle= binding.titleUpdateEditText.text.toString()
            val newContent = binding.contentUpdateEditText.text.toString()
            val updatedNote = Note (noteId,newTitle,newContent)
           db.updateNote(updatedNote)

            finish()
           Toast.makeText(this,"Changes Saved", Toast.LENGTH_SHORT).show()


        }




    }
}