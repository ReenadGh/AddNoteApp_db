package com.example.notesapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHolder(
    context: Context?

) : SQLiteOpenHelper(context, "Notes.db", null, 1) {
var sqlLiteDatabase : SQLiteDatabase = writableDatabase
    override fun onCreate(db: SQLiteDatabase?) {
        if (db != null) {
       db.execSQL("create table notes (Note text)")

        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    fun addNote(note : String  ) : Long{

        val cv = ContentValues()
        cv.put("Note", note)
       var status = sqlLiteDatabase.insert("notes" , null , cv)
        return status
    }


}