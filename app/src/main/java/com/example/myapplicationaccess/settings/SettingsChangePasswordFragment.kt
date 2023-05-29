package com.example.myapplicationaccess.settings

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.myapplicationaccess.R

class SettingsChangePasswordFragment : Fragment() {

    private lateinit var editTextPassword: EditText
    private lateinit var passwordVisibilityToggle: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings_change_password, container, false)

        editTextPassword = view.findViewById(R.id.et_password)
        passwordVisibilityToggle = view.findViewById(R.id.passwordVisibilityToggle)

        passwordVisibilityToggle.setOnClickListener {
            togglePasswordVisibility()
        }

        val buttonOk = view.findViewById<Button>(R.id.btn_ok)
        buttonOk.setOnClickListener {
            // Обработка нажатия на кнопку "Ок"
            val newPassword = editTextPassword.text.toString()
            // Ваш код для сохранения нового пароля

            // Отображение всплывающего сообщения об успешной смене пароля
            val message = "Пароль успешно изменен"
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()

            // Закрытие фрагмента SettingsChangePasswordFragment и возврат к фрагменту SettingsFragment
            parentFragmentManager.popBackStack()
        }

        return view
    }

    private fun togglePasswordVisibility() {
        val isPasswordVisible =
            editTextPassword.inputType and InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD != 0
        if (isPasswordVisible) {
            // Если пароль видимый, то скрыть его
            editTextPassword.inputType =
                editTextPassword.inputType and InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD.inv()
            passwordVisibilityToggle.setImageResource(R.drawable.baseline_visibility_off_24)
        } else {
            // Если пароль скрытый, то отобразить его
            editTextPassword.inputType =
                editTextPassword.inputType or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            passwordVisibilityToggle.setImageResource(R.drawable.baseline_visibility_24)
        }
        // Обновить фокус в поле ввода пароля, чтобы скрытие/отображение пароля применилось немедленно
        editTextPassword.requestFocus()
        // Установить курсор в конец текста
        editTextPassword.setSelection(editTextPassword.text?.length ?: 0)
    }
}
