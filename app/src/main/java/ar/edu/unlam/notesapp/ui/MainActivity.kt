package ar.edu.unlam.notesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.unlam.nota.ui.NotaActivity
import ar.edu.unlam.notesapp.R
import ar.edu.unlam.notesapp.ui.adapters.NotesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_note.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vm:MainViewModel by viewModels()
        val dato=vm.nota

        nuevaNota.setOnClickListener{
            startActivity(Intent(this,NotaActivity::class.java))}

        initRecycler(dato)


    }

    fun initRecycler(dato:List<Note>){
        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=NotesAdapter(dato)
        recyclerView.adapter=adapter
    }

}