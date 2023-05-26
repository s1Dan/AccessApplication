package com.example.myapplicationaccess.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class MySQLManager {
    private val url = "jdbc:mysql://localhost:3306/testusers"
    private val username = "root"
    private val password = "root"
    private var connection: Connection? = null

    fun connect() {
        try {
            connection = DriverManager.getConnection(url, username, password)
            println("Подключение к базе данных успешно")
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun disconnect() {
        try {
            connection?.close()
            println("Отключение от базы данных успешно")
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    // Пример выполнения операции с базой данных
    fun executeQuery(query: String) {
        try {
            val statement = connection?.createStatement()
            val resultSet = statement?.executeQuery(query)

            // Обработка результатов
            while (resultSet?.next() == true) {
                val id = resultSet.getInt("id")
                val name = resultSet.getString("name")
                println("ID: $id, Name: $name")
            }

            resultSet?.close()
            statement?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}

fun main() {
    val manager = MySQLManager()
    manager.connect()

    // Пример выполнения операции с базой данных
    val query = "SELECT id, name FROM users"
    manager.executeQuery(query)

    manager.disconnect()
}


