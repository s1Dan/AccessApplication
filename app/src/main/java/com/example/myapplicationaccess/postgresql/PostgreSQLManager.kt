package com.example.myapplicationaccess.postgresql

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class PostgreSQLManager {
    private lateinit var connection: Connection

    init {
        connect()
    }

    private fun connect() {
        val url = "jdbc:postgresql://your_database_url"
        val username = "your_username"
        val password = "your_password"

        try {
            Class.forName("org.postgresql.Driver")
            connection = DriverManager.getConnection(url, username, password)
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    fun executeNonQuery(query: String) {
        try {
            val statement = connection.createStatement()
            statement.executeUpdate(query)
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }
}

