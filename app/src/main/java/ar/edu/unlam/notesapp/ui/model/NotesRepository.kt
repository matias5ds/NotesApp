package ar.edu.unlam.notesapp.model

interface NotesRepository {
    suspend fun save(note:Nota)

    suspend fun getById(id:Long):Note

    suspend fun getAll():List<Note>

    suspend fun updateNote(note:Note)

    suspend fun delete(id:Long)
}