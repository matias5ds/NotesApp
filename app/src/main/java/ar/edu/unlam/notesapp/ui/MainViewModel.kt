package ar.edu.unlam.notesapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ar.edu.unlam.notesapp.ui.Note

class MainViewModel :ViewModel(){

    var nota= listOf(

        Note("Green Lanter","Esta es mi primer nota","https://cursokotlin.com/wp-content/uploads/2017/07/green-lantern.jpg"),
        Note("Soy Batman","esta es la segunda","https://cursokotlin.com/wp-content/uploads/2017/07/batman.jpg"),
        Note("y esta es la tercera","este es el Pedro Parker","https://cursokotlin.com/wp-content/uploads/2017/07/spiderman.jpg"),
        Note("Esta nota es nueva","El Flash","https://cursokotlin.com/wp-content/uploads/2017/07/flash.png")
    )

    val notesLiveData=MutableLiveData<List<Note>>(nota)


}