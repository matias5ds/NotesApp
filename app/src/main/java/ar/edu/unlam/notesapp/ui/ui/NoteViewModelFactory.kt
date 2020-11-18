package ar.edu.unlam.notesapp.ui

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import ar.edu.unlam.notesapp.data.NoteDatabase
import ar.edu.unlam.notesapp.data.RoomNotesRepository

class NoteViewModelFactory(
    private val applicationContext: Context):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      val database=  Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            "note-db"
        ).build()

        val dao=database.notesDao()

      return NoteViewModel(
          RoomNotesRepository(dao)
      )as T
    }
}