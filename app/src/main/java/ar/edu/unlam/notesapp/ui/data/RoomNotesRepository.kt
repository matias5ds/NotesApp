package ar.edu.unlam.notesapp.data

import ar.edu.unlam.notesapp.model.Nota
import ar.edu.unlam.notesapp.model.Note
import ar.edu.unlam.notesapp.model.NotesRepository

class RoomNotesRepository(private val noteDao:NotesDao): NotesRepository {
    override suspend fun save(note: Nota) {
        val entity=NoteEntity(
            img=note.img,
            title=note.title,
            content = note.content
        )
     noteDao.saveNote(entity)
    }

    override suspend fun getAll(): List<Note> {
        return noteDao.getAll()
            .map{Note(it.id,it.img,it.title,it.content)}
    }
    override suspend fun getById(id:Long): Note {
           val nota =noteDao.getById(id)
        return Note(
            nota.id,nota.img,nota.title,nota.content)
    }

    override suspend fun updateNote(note:Note){
        val entity=NoteEntity(
            id = note.id,
            img=note.img,
            title=note.title,
            content = note.content
        )
        noteDao.updateNote(entity)

    }
    override suspend fun delete(id:Long){
        noteDao.delete(id)


    }
}