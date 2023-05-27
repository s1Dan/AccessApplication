package com.example.myapplicationaccess.mysql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class MySQLManager {
    private val url = "jdbc:mysql://localhost:3306/usersdb"
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

    fun executeQuery(query: String) {
        try {
            val statement = connection?.createStatement()
            val resultSet = statement?.executeQuery(query)

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

    fun signIn(login: String, password: String): Boolean {
        var success = false
        try {
            val query = "SELECT COUNT(*) FROM users WHERE login = ? AND password = ?"
            val preparedStatement = connection?.prepareStatement(query)
            preparedStatement?.setString(1, login)
            preparedStatement?.setString(2, password)
            val resultSet = preparedStatement?.executeQuery()

            resultSet?.next()
            val count = resultSet?.getInt(1)

            if (count != null && count > 0) {
                success = true
            }

            resultSet?.close()
            preparedStatement?.close()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return success
    }
}

/*
fun main() {

    val manager = MySQLManager()
    manager.connect()

    val query = "SELECT id, name FROM users"
    manager.executeQuery(query)

    val login = "user"
    val password = "password"
    val success = manager.signIn(login, password)
    println("Авторизация: $success")

    manager.disconnect()
}

 */



