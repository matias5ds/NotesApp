package ar.edu.unlam.notesapp.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ar.edu.unlam.notesapp.R

import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_note.*
import kotlinx.android.synthetic.main.activity_new_note.*

import kotlinx.android.synthetic.main.activity_new_note.btn_choose_img
import kotlinx.android.synthetic.main.activity_new_note.btn_save
import kotlinx.android.synthetic.main.activity_new_note.notes_content
import kotlinx.android.synthetic.main.activity_new_note.notes_image
import kotlinx.android.synthetic.main.activity_new_note.notes_title
import kotlinx.android.synthetic.main.item_note.*
import org.koin.android.viewmodel.ext.android.viewModel


    class NewNoteActivity: AppCompatActivity(){
    var SELECT_PHOTO=1;
        var im:String="";
    val noteViewModel : NewNoteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_note)

      btn_save.setOnClickListener {
            noteViewModel.saveNote( im,notes_title.editText?.text.toString(),notes_content.editText?.text.toString())
          this@NewNoteActivity.finish()

      }


    }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode,resultCode,data)
            when (requestCode) {

                SELECT_PHOTO -> if (resultCode == -1) {
                    data!!.data?.let { returnUri ->
                        this.contentResolver?.takePersistableUriPermission(returnUri, Intent.FLAG_GRANT_READ_URI_PERMISSION)
                        loadPicture(returnUri)
                    }
                }
            }
        }
        private fun loadPicture(uri: Uri) {
            im=uri.toString();
            Picasso.get().load(uri).error(R.drawable.nofoto).into(notes_image)
        }
    companion object{
        val ID:String="ID"}
}