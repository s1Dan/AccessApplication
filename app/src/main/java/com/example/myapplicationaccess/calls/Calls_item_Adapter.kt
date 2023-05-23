package com.example.myapplicationaccess.calls

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationaccess.R

class Calls_item_Adapter(private val items: List<Calls_item>) : RecyclerView.Adapter<Calls_item_Adapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.calls_item_layout, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item_calls = items[position]
        holder.bind(item_calls)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Calls_item) {
            itemView.findViewById<TextView>(R.id.tv_missed_call_Date).text = item.data
            itemView.findViewById<TextView>(R.id.tv_missed_call_Time).text = item.time
        }
    }
}