package ar.edu.unlam.notesapp.ui.adapters
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import ar.edu.unlam.notesapp.R
import ar.edu.unlam.notesapp.ui.Note
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_note.view.*


class NotesAdapter(val notes:List<Note>):RecyclerView.Adapter<NotesAdapter.ViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_note,parent,false))
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.render(notes[position])
    }


    class  ViewHolder(val  view: View):RecyclerView.ViewHolder(view) {
        fun render(notes: Note){
            view.lvTitulo.text=notes.titulo
            view.lvContenido.text=notes.contenido
            Picasso.get().load(notes.image).into(view.lvImage)
            view.setOnClickListener{ Toast.makeText(view.context,"Has seleccionado: ${notes.titulo}",Toast.LENGTH_SHORT).show()}
        }

    }
}