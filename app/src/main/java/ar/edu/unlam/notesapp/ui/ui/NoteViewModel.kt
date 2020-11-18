package ar.edu.unlam.notesapp.ui



import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.notesapp.model.Note
import ar.edu.unlam.notesapp.model.NotesRepository
import kotlinx.coroutines.launch


class NoteViewModel(private val notesRepository: NotesRepository) : ViewModel() {

    val noteLiveData= MutableLiveData<List<Note>>()

init{
       viewModelScope.launch {
           val allNotes = notesRepository.getAll()
           noteLiveData.value = allNotes;
       }
   }

    fun updateList(){
        viewModelScope.launch {
            noteLiveData.value = notesRepository.getAll()
        }
    }

   }





