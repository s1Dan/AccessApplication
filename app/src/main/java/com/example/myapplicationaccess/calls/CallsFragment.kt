package com.example.myapplicationaccess.calls

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationaccess.R


class CallsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var item_Adapter: Calls_item_Adapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calls, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            Calls_item("01/03/2023", "12-01", ),
            Calls_item("тест 2", "13-02",),
            Calls_item("15/12/2022", "15-12",)
        )
        item_Adapter = Calls_item_Adapter(items)
        recyclerView.adapter = item_Adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

    }


}