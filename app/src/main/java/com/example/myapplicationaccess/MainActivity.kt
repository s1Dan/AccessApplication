package com.example.myapplicationaccess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplicationaccess.calls.CallsFragment
import com.example.myapplicationaccess.cameras.CamerasFragment
import com.example.myapplicationaccess.login.LoginFragment
import com.example.myapplicationaccess.settings.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_nav_view)
        // Устанавливаем слушатель на выбор элементов меню навигации
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.fragment_calls -> {
                    replaceFragment(CallsFragment()) // Заменяем текущий фрагмент на FragmentCalls
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.fragment_cameras -> {
                    replaceFragment(CamerasFragment()) // Заменяем текущий фрагмент на FragmentCameras
                    return@setOnNavigationItemSelectedListener true
                }

                R.id.fragment_settings -> {
                    replaceFragment(SettingsFragment()) // Заменяем текущий фрагмент на FragmentSettings
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

        // Устанавливаем фрагмент по умолчанию при старте активити
        if (savedInstanceState == null) {
            // Открываем центральный фрагмент при запуске приложения
            bottomNavigationView.selectedItemId = R.id.fragment_cameras
        }

        // Проверяем, нужно ли скрыть BottomNavigationView
        if (isUserLoggedIn()) {
            bottomNavigationView.visibility = View.VISIBLE
        } else {
            bottomNavigationView.visibility = View.GONE
        }

        // Проверяем, авторизован ли пользователь
        if (!isUserLoggedIn()) {
            // Пользователь не авторизован, открываем LoginFragment
            replaceFragment(LoginFragment())
        } else {
            // Пользователь авторизован, открываем центральный фрагмент
            bottomNavigationView.selectedItemId = R.id.fragment_cameras
        }
    }

    // Функция для замены фрагмента в контейнере fragment_container
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }


    // Функция для проверки авторизации пользователя
    private fun isUserLoggedIn(): Boolean {
        // Ваша логика проверки авторизации пользователя здесь
        // Верните true, если пользователь авторизован, иначе false

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        return isLoggedIn
        //return false
    }
}
