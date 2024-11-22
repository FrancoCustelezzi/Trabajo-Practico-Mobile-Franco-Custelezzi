package com.example.tp1francodayana

import android.app.Application
import com.example.tp1francodayana.data.TP1DB
import com.example.tp1francodayana.data.User
import com.example.tp1francodayana.data.UserDAO

class UserRepository(application: Application) {

    private val userDao: UserDAO
    private val database: TP1DB

    init {
        database = TP1DB.getDatabase()
        userDao = database.userDao()
    }

    suspend fun delete(user: User) {
        userDao.delete(user)
    }

}