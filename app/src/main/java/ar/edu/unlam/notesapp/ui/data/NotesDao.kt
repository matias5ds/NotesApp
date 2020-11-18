package ar.edu.unlam.notesapp.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {


    @Insert
    suspend fun saveNote(entity: NoteEntity)

    @Query("SELECT * FROM note WHERE id=:id ")
    suspend fun getById(id: Long):NoteEntity

    @Query("SELECT * FROM note")
    suspend fun getAll():List<NoteEntity>

    @Update
    suspend fun updateNote(note:NoteEntity)

    @Query("DELETE FROM note WHERE note.id=:id")
    suspend fun delete(id:Long)
}