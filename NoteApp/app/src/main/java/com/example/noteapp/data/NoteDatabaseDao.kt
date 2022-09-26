package com.example.noteapp.data

import androidx.room.*
import com.example.noteapp.model.Note

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * FROM notes_tbl")
    fun getNotes(): List<Note>

    @Query("SELECT * FROM notes_tbl WHERE id = :id")
    fun getNoteById(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("DELETE * FROM notes_tbl")
    fun deleteAll()

    @Delete
    fun deleteNote(note: Note)

}
