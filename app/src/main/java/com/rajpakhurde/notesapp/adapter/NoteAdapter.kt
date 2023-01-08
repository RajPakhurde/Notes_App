package com.rajpakhurde.notesapp.adapter

import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rajpakhurde.notesapp.R
import com.rajpakhurde.notesapp.entities.Notes

class NoteAdapter(val arrayList: List<Notes>): RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes,parent,false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
         holder.tvTitle.text = arrayList[position].title
         holder.tvDecs.text = arrayList[position].notetext
         holder.tvDataTimeViewItem.text = arrayList[position].dateTime
    }

    override fun getItemCount(): Int = arrayList.size

    inner class NoteViewHolder(view: View): RecyclerView.ViewHolder(view){
         val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
         val tvDecs = view.findViewById<TextView>(R.id.tvDesc)
         val tvDataTimeViewItem = view.findViewById<TextView>(R.id.tvDateTimeViewItem)
    }
}