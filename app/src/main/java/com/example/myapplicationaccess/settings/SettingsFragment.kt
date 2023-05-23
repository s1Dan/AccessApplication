package com.example.myapplicationaccess.settings

import SettingsChangePasswordFragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.myapplicationaccess.R

class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val telephoneLinearLayout = view.findViewById<LinearLayout>(R.id.change_telephone)
        telephoneLinearLayout.setOnClickListener {
            val newFragment = SettingsChangeTelephoneFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit()
        }

        val passwordLinearLayout = view.findViewById<LinearLayout>(R.id.change_password)
        passwordLinearLayout.setOnClickListener {
            val newFragment = SettingsChangePasswordFragment()

            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment)
                .addToBackStack(null)
                .commit()
        }





        return view
    }
}