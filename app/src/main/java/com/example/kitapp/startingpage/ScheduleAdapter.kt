package com.example.kitapp.startingpage

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kitapp.R
import com.example.kitapp.database.ScheduleItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ScheduleAdapter: RecyclerView.Adapter<ScheduleAdapter.ViewHolder>(){

    var data= listOf<ScheduleItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var up = listOf<ScheduleItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var down = listOf<ScheduleItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]

        holder.nameOfDay.text = item.nameDay
        holder.firstLesson.text = item.firstLesson
        holder.secondLesson.text = item.secondLesson
        holder.thirdLesson.text = item.thirdLesson
        holder.fourthLesson.text = item.fourthLesson
        holder.fifthLesson.text = item.fifthLesson
        holder.sixthLesson.text = item.sixthLesson
        holder.seventhLesson.text = item.seventhLesson
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun filter(){
        for (day in data){
            if (day.whichDay){
                up.plus(day)
            } else{
                down.plus(day)
            }
        }
    }

    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val nameOfDay: TextView = itemView.findViewById(R.id.name_of_day)
        val firstLesson: TextView = itemView.findViewById(R.id.first_lesson)
        val secondLesson: TextView = itemView.findViewById(R.id.second_lesson)
        val thirdLesson: TextView = itemView.findViewById(R.id.third_lesson)
        val fourthLesson: TextView = itemView.findViewById(R.id.fourth_lesson)
        val fifthLesson: TextView = itemView.findViewById(R.id.fifth_lesson)
        val sixthLesson: TextView = itemView.findViewById(R.id.sixth_lesson)
        val seventhLesson: TextView = itemView.findViewById(R.id.seventh_lesson)
    }

}

class TextItemViewHolder(val textView: TextView): RecyclerView.ViewHolder(textView)