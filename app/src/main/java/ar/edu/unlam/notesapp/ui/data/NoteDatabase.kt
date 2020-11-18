package ar.edu.unlam.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    version = 1,
    entities = [NoteEntity::class]
)

abstract class NoteDatabase:RoomDatabase() {
    abstract fun notesDao():NotesDao

}