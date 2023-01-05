package com.rajpakhurde.notesapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class Notes(

    @PrimaryKey(autoGenerate = true)
    val id: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "sub_title")
    val subTitle: String,

    @ColumnInfo(name = "date_time")
    val dateTime: String,

    @ColumnInfo(name = "note_text")
    val notetext: String,

    @ColumnInfo(name = "img_path")
    val imgPath: String,

    @ColumnInfo(name = "web_link")
    val webLink: String,

    @ColumnInfo(name = "color")
    val color: String
){
    override fun toString(): String {
        return "$title : $dateTime"
    }
}
