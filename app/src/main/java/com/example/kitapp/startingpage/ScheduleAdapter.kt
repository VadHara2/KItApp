package com.example.kitapp.startingpage

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kitapp.R
import com.example.kitapp.database.ScheduleItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleAdapter: RecyclerView.Adapter<TextItemViewHolder>(){
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
        Log.i("lol","${item.nameDay}")
        holder.textView.text = item.nameDay
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)