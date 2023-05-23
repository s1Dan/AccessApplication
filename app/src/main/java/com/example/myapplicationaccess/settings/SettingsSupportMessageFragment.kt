package com.example.myapplicationaccess.settings

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplicationaccess.R

class SettingsSupportMessageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_support_message, container, false)

        val buttonSend = view.findViewById<Button>(R.id.btn_supportMessage)
        buttonSend.setOnClickListener {
            // Обработка нажатия на кнопку "Ок"

            // Код для отправки содержимого EditText

            // Отображение всплывающего сообщения об успешной отправке сообщения
            val message = "Сообщение успешно отправлено: $"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            Log.d("TAG","123" )

            // Закрытие фрагмента SettingsSupportMessageFragment и возврат к фрагменту SettingsFragment
            parentFragmentManager.popBackStack()
        }
        return view
    }
}

