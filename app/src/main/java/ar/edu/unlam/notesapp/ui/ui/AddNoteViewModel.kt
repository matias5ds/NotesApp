package ar.edu.unlam.notesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.unlam.notesapp.model.Nota
import ar.edu.unlam.notesapp.model.NotesRepository
import kotlinx.coroutines.launch

class NewNoteViewModel(
    private val notesRepository: NotesRepository
): ViewModel() {

    val notesLiveData = MutableLiveData<Nota>()
    fun saveNote(img: String, title:String, content:String) {
        viewModelScope.launch {
            notesRepository.save(Nota( img = img, title = title, content= content))
        }
    }

}