package ar.edu.unlam.notesapp.ui


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import ar.edu.unlam.notesapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_edit_note.*
import kotlinx.android.synthetic.main.activity_new_note.*
import kotlinx.android.synthetic.main.item_note.*

import java.lang.RuntimeException
import org.koin.android.viewmodel.ext.android.viewModel

class EditNoteActivity: AppCompatActivity(){
    var SELECT_PHOTO=1;
    var im: String=""
    var id:Long=0
    private val noteViewModel : EditNoteViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_note)
        if(intent.hasExtra(ID)){
            verNotaaEditar(intent.extras!!.getLong(ID,0))
        }else{
            throw RuntimeException("id error")
        }
        btn_choose_img.setOnClickListener {
            pickImage()
        }
        btn_save.setOnClickListener {
            noteViewModel.updateNote(id,im ,notes_title.editText?.text.toString(),notes_content.editText?.text.toString())
            noteViewModel.updateList()
            this@EditNoteActivity.finish()

        }
        /*
        btn_delete_note.setOnClickListener {
            noteViewModel.deleteNote(id)
            this@EditNoteActivity.finish()
        }  */
    }
    private fun verNotaaEditar(idNote:Long){
        noteViewModel.getNotaPorId(idNote)

        noteViewModel.notaLiveData.observe(this, Observer {
            id=it.id;
            notes_title.editText?.setText(it.title)
            notes_content.editText?.setText(it.content)
            im=it.img
            Picasso.get()
                .load(Uri.parse(it.img))
                .error(R.drawable.nofoto)
                .into(notes_image)
        }
        )


    }

    fun pickImage(){
        var image=Intent(Intent.ACTION_OPEN_DOCUMENT)
        image.type="image/*"
        image.flags = (Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_GRANT_WRITE_URI_PERMISSION or Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
        image= Intent.createChooser(image, resources.getString(R.string.elegir_imagen))
        startActivityForResult(image,SELECT_PHOTO)

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
        Picasso.get()
            .load(uri)
            .error(R.drawable.nofoto)
            .into(notes_image)
    }

    companion object{
        val ID:String="id"}
}