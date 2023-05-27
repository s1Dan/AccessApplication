package com.example.myapplicationaccess.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapplicationaccess.R
import com.example.myapplicationaccess.mysql.MySQLManager


class LoginFragment : Fragment() {

    private lateinit var dbManager: MySQLManager
    private lateinit var ed_emailLogin: EditText
    private lateinit var ed_passwordLogin: EditText
    private lateinit var btn_SignIn: Button
    private lateinit var btn_Registration: Button
    private lateinit var btn_ForgetPassword: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        ed_emailLogin = view.findViewById(R.id.ed_emailLogin)
        ed_passwordLogin = view.findViewById(R.id.ed_passwordLogin)
        btn_SignIn = view.findViewById(R.id.btn_SignIn)
        btn_Registration = view.findViewById(R.id.btn_Registration)
        btn_ForgetPassword = view.findViewById(R.id.btn_ForgetPassword)

        dbManager = MySQLManager()
        dbManager.connect()

        btn_SignIn.setOnClickListener {
            val login = ed_emailLogin.text.toString()
            val password = ed_passwordLogin.text.toString()

            if (login.isNotEmpty() && password.isNotEmpty()) {
                val isSignedIn = dbManager.signIn(login, password)

                if (isSignedIn) {
                    // Вход выполнен успешно
                    Toast.makeText(requireContext(), "Вход выполнен успешно", Toast.LENGTH_SHORT).show()
                } else {
                    // Неверные учетные данные
                    Toast.makeText(requireContext(), "Неверные учетные данные", Toast.LENGTH_SHORT).show()
                }
            } else {
                // Заполните все поля
                Toast.makeText(requireContext(), "Заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        dbManager.disconnect()
    }
}