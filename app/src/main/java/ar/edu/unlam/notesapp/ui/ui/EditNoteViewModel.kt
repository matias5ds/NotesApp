package ar.edu.unlam.notesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.notesapp.model.Note
import kotlinx.coroutines.launch

class EditNoteViewModel (
    private val notesRepository: NotesRepository
) : ViewModel() {
    val actualizarLista=MutableLiveData<List<Note>>()
    val notaLiveData=MutableLiveData<Note>()

    fun getNotaPorId(id:Long) {
        viewModelScope.launch {
            notaLiveData.value=notesRepository.getById(id)
        }

    }
    fun updateNote(id:Long, img: String, title:String, content:String){
        viewModelScope.launch {
            notesRepository.updateNote(Note( id = id,img = img, title = title, content = content))

        }

    }
    fun deleteNote(id:Long){
        viewModelScope.launch {
            notesRepository.delete(id)
        }
    }
    fun updateList(){
        viewModelScope.launch {
            actualizarLista.value = notesRepository.getAll()
        }
    }
}