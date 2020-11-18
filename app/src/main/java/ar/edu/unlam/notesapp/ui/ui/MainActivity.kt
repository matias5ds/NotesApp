package ar.edu.unlam.notesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import ar.edu.unlam.notesapp.R
import kotlinx.android.synthetic.main.activity_main.*
import androidx.lifecycle.Observer
import ar.edu.unlam.notesapp.ui.ui.adapters.NoteAdapter
import org.koin.android.viewmodel.ext.android.viewModel



class MainActivity : AppCompatActivity() {
    private lateinit var adapter: NoteAdapter
    private val noteViewModel : NoteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn_New_Note.setOnClickListener{
            startActivity(Intent(this, NewNoteActivity::class.java))
        }


        setObservers()


    }
    @Override
    public override fun onResume(){
        super.onResume()
        noteViewModel.updateList()

    }

  private fun setObservers() {
      noteViewModel.noteLiveData.observe(this, Observer {

      })



}
}