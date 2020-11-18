package ar.edu.unlam.notesapp.data

import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id: Long = 0,

    @ColumnInfo(name = "img")
    val img: String="",

    @ColumnInfo(name = "title")
    val title: String="",

    @ColumnInfo(name = "content")
    val content: String=""

)

