package com.example.myapplicationaccess.registration

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplicationaccess.R
import com.example.myapplicationaccess.postgresql.PostgreSQLManager


class RegistrationFragment : Fragment() {

    private lateinit var dbManager: PostgreSQLManager
    private lateinit var editTextFirstName: EditText
    private lateinit var editTextLastName: EditText
    private lateinit var editTextBirthday: EditText
    private lateinit var editTextEmail: EditText
    private lateinit var editTextPhoneNumber: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_registration, container, false)
        dbManager = PostgreSQLManager()

        // Получение ссылок на EditText
        val editTextFirstName = view.findViewById<EditText>(R.id.ed_firstName)
        val editTextLastName = view.findViewById<EditText>(R.id.ed_registration_secondName)
        val editTextBirthday = view.findViewById<EditText>(R.id.ed_registration_day)
        val editTextEmail = view.findViewById<EditText>(R.id.ed_registration_email)
        val editTextPhoneNumber = view.findViewById<EditText>(R.id.ed_registration_telephone)
        val editTextPassword = view.findViewById<EditText>(R.id.ed_registration_password)
        val buttonRegister = view.findViewById<Button>(R.id.btn_Registration)

        // Обработчик нажатия на кнопку "Регистрация"
        buttonRegister.setOnClickListener {
            val firstName = editTextFirstName.text.toString()
            val lastName = editTextLastName.text.toString()
            val birthday = editTextBirthday.text.toString()
            val email = editTextEmail.text.toString()
            val phoneNumber = editTextPhoneNumber.text.toString()
            val password = editTextPassword.text.toString()

            if (firstName.isNotEmpty() && lastName.isNotEmpty() && birthday.isNotEmpty() &&
                email.isNotEmpty() && phoneNumber.isNotEmpty() && password.isNotEmpty()) {

                val query = "INSERT INTO users (first_name, last_name, birthday, email, phone_number, password) " +
                        "VALUES ('$firstName', '$lastName', '$birthday', '$email', '$phoneNumber', '$password')"
                dbManager.executeNonQuery(query)

                clearFields()
            } else {
                Toast.makeText(requireContext(),
                    "Пожалуйста, заполните все поля",
                    Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
    private fun clearFields() {
        editTextFirstName.text.clear()
        editTextLastName.text.clear()
        editTextBirthday.text.clear()
        editTextEmail.text.clear()
        editTextPhoneNumber.text.clear()
        editTextPassword.text.clear()
    }

}
