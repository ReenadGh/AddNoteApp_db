package com.example.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var noteText : EditText
    lateinit var addNoteB : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       var dbhr = DBHolder(applicationContext)
       var status = dbhr.addNote("reenad")

        noteText = findViewById(R.id.noteE)
        addNoteB = findViewById(R.id.addB)

        val myRV = findViewById<RecyclerView>(R.id.rvMain)
        val myNotes = arrayListOf<Note>()


        addNoteB.setOnClickListener {

            if (noteText.text.isNotEmpty()){

                var status = dbhr.addNote(noteText.text.toString())
                if (status > -1){

                    Toast.makeText(this, "note added !", Toast.LENGTH_SHORT).show()
                    myNotes.add(Note(noteText.text.toString()))
                    myRV.adapter = RecyclerViewAdapter(myNotes)
                    myRV.layoutManager = LinearLayoutManager(this)
                    myRV.adapter!!.notifyDataSetChanged()

                }
                else{
                    Toast.makeText(this, "error : note not added !", Toast.LENGTH_SHORT).show()

                }
            }

        }

    }
}