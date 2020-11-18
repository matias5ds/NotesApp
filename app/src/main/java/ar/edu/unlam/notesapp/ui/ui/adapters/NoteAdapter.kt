package ar.edu.unlam.notesapp.ui.ui.adapters
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.notesapp.R
import ar.edu.unlam.notesapp.model.Note
import ar.edu.unlam.notesapp.ui.EditNoteActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_note.view.*


class NoteAdapter: RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var notesList = mutableListOf<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view=LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note,parent,false)
        return NoteViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        notesList[position].let{note->
            holder.itemView.noteId.text= note.id.toString()
            holder.itemView.notes_title.text=note.title
            holder.itemView.notes_content.text=note.content

            Picasso.get()
                .load(Uri.parse(note.img))
                .fit()
                .error(R.drawable.nofoto)
                .into(holder.itemView.notes_image)

            holder?.nota=note
        }
    }
    fun submitList(it: List<Note>) {
        notesList.clear()
        notesList.addAll(it)
    }
    class NoteViewHolder(view: View,var nota:Note?=null): RecyclerView.ViewHolder(view){
        init{

            view.btn_edit_note.setOnClickListener {
                val intent = Intent(view.context, EditNoteActivity::class.java)
                intent.putExtra(EditNoteActivity.ID,nota!!.id)
                view.context.startActivity(intent)
            }

        }
    }

}
