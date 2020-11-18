package ar.edu.unlam.notesapp

import android.app.Application
import android.content.Context
import androidx.room.Room
import ar.edu.unlam.notesapp.data.NoteDatabase
import ar.edu.unlam.notesapp.data.NotesDao
import ar.edu.unlam.notesapp.data.RoomNotesRepository
import ar.edu.unlam.notesapp.model.NotesRepository
import ar.edu.unlam.notesapp.ui.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class NotesApp : Application() {

    val appModule =module{
        single<NotesDao> {dataBaseProvider(get()).notesDao()}
        single<NotesRepository> { RoomNotesRepository(get()) }

        viewModel{ NoteViewModel(get()) }
        viewModel { EditNoteViewModel(get()) }
        viewModel { NewNoteViewModel(get()) }
    }
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@NotesApp)
            koin.loadModules(listOf(appModule))


        }
    }


    fun dataBaseProvider(context: Context): NoteDatabase {

        return Room.databaseBuilder(context, NoteDatabase::class.java,"notes-db").build()
    }

}