package com.example.kitapp.startingpage

import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kitapp.R
import com.example.kitapp.database.ScheduleItem

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>(){
    var data= listOf<ScheduleItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.text = item.nameDayId
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)