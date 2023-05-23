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


class SettingsChangeTelephoneFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_change_telephone, container, false)

        val buttonOk = view.findViewById<Button>(R.id.btn_ok)
        buttonOk.setOnClickListener {
            // Обработка нажатия на кнопку "Ок"
            val newPhoneNumber = view.findViewById<EditText>(R.id.editText).text.toString()
            // Ваш код для сохранения нового номера телефона

            // Отображение всплывающего сообщения об успешной смене номера телефона
            val message = "Номер телефона успешно изменен: $newPhoneNumber"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
            Log.d("TAG","234" )

            // Закрытие фрагмента SettingsChangeTelephoneFragment и возврат к фрагменту SettingsFragment
            parentFragmentManager.popBackStack()
        }
        return view
    }
}