package ar.edu.unlam.notesapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ar.edu.unlam.nota.ui.NotaActivity
import ar.edu.unlam.notesapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        botonBienvenido.setOnClickListener(){
            startActivity(Intent(this,NotaActivity::class.java))
        }

    }
}