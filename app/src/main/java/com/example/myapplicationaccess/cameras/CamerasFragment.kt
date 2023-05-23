package com.example.myapplicationaccess.cameras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationaccess.R


class CamerasFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var item_Adapter: Cameras_item_Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cameras, container, false)

        recyclerView = view.findViewById(R.id.recyclerView_cameras)
        item_Adapter = Cameras_item_Adapter(listOf(
            Cameras_item("123"),
            Cameras_item("456"),
            Cameras_item("789")
        ))

        recyclerView.adapter = item_Adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        return view
    }

}