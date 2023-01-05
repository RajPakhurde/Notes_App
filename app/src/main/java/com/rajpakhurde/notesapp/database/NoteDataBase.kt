package com.rajpakhurde.notesapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rajpakhurde.notesapp.dao.NoteDao
import com.rajpakhurde.notesapp.entities.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {

    companion object{
        var noteDataBase: NoteDataBase? = null

        @Synchronized
        fun getDataBase(context: Context): NoteDataBase {
            if(noteDataBase != null){
                noteDataBase = Room.databaseBuilder(
                    context,
                    NoteDataBase::class.java,
                    "notes_db"
                ).build()
            }
            return noteDataBase!!
        }
    }

    abstract fun noteDao(): NoteDao
}