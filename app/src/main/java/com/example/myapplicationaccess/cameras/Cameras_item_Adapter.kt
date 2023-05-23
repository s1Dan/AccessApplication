package com.example.myapplicationaccess.cameras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationaccess.R

class Cameras_item_Adapter(private val items: List<Cameras_item>): RecyclerView.Adapter<Cameras_item_Adapter.ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cameras_item_layout, parent, false)

        return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item_cameras = items[position]
        holder.bind(item_cameras)
    }


    override fun getItemCount(): Int {
        return items.size
    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: Cameras_item) {
            itemView.findViewById<TextView>(R.id.tv_description).text = item.address
        }
    }

}