package ar.edu.unlam.nota.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unlam.nota.R
import kotlinx.android.synthetic.main.activity_nota.*

class NotaActivity:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota)

       /* guardar.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))}*/
    }
}