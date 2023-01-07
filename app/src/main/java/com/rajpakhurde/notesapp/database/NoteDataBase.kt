package com.rajpakhurde.notesapp.database

import android.content.Context
import android.util.Log
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.rajpakhurde.notesapp.dao.NoteDao
import com.rajpakhurde.notesapp.entities.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NoteDataBase: RoomDatabase() {

    companion object{
        @Volatile
        var INSTANCE: NoteDataBase? = null
        fun getDataBase(context: Context): NoteDataBase {
             synchronized(this){
                 var instance = INSTANCE
                 if(instance == null){
                     instance = Room.databaseBuilder(
                         context.applicationContext,
                         NoteDataBase::class.java,
                         "room.db"
                     ).build()
                 }
                 return instance
             }
        }
    }

    abstract fun noteDao(): NoteDao
}