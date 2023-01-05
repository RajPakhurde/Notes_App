package com.rajpakhurde.notesapp.dao

import androidx.room.*
import com.rajpakhurde.notesapp.entities.Notes

@Dao
interface NoteDao {

    @get: Query("SELECT * FROM notes ORDER BY id DESC")
    val noteList: List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Delete
    fun deleteNotes(notes: Notes)
}