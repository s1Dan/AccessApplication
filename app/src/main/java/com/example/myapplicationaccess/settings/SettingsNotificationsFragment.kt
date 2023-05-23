package com.example.myapplicationaccess.settings

import android.database.Cursor
import android.media.RingtoneManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.example.myapplicationaccess.R
import com.google.android.material.switchmaterial.SwitchMaterial

class SettingsNotificationsFragment : Fragment() {

    private lateinit var switchNotifications: SwitchCompat
    private lateinit var spinnerSound: Spinner

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_notifications, container, false)

        // Находим ссылки на элементы разметки
        switchNotifications = view.findViewById(R.id.notifications_switch)
        spinnerSound = view.findViewById(R.id.notifications_spinnerSound)

        // Устанавливаем обработчик изменения состояния переключателя
        switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            // Обработка состояния переключателя
            if (isChecked) {
                // Уведомления отключены
                Toast.makeText(requireContext(), "Уведомления включены", Toast.LENGTH_SHORT).show()
            } else {
                // Уведомления включены
                Toast.makeText(requireContext(), "Уведомления выключены", Toast.LENGTH_SHORT).show()
            }
        }

        // Создаем адаптер для списка звуков
        //val soundList = listOf("Звук 1", "Звук 2", "Звук 3")


        val ringtoneManager = RingtoneManager(context)
        ringtoneManager.setType(RingtoneManager.TYPE_NOTIFICATION)
        val cursor: Cursor = ringtoneManager.cursor

        val soundList = mutableListOf<String>()

        while (cursor.moveToNext()) {
            val title: String = cursor.getString(RingtoneManager.TITLE_COLUMN_INDEX)
            soundList.add(title)
        }

        cursor.close()
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, soundList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerSound.adapter = adapter


        // Устанавливаем обработчик выбора элемента из списка звуков
        spinnerSound.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedSound = parent?.getItemAtPosition(position).toString()
                // Обработка выбора звука
                Toast.makeText(requireContext(), "Выбран звук: $selectedSound", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Обработка случая, когда ничего не выбрано
            }
        }
        return view
    }
}

