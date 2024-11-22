package com.example.tp1francodayana

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.tp1francodayana.data.TP1DB
import com.example.tp1francodayana.data.User
import kotlinx.coroutines.launch

class UserViewmodel(application: Application) : AndroidViewModel(application) {

    val userDAO = TP1DB.getDatabase().userDao()
    val readAllData: LiveData<List<User>> = userDAO.readAllData()
    private val userRepository: UserRepository = UserRepository(application)

    fun insert (user:User){
        userDAO.insert(user = user)
    }

    fun selectUserByMail (user:User): User{
        return userDAO.getUserById(mail = user.mail)
    }

    fun delete(user: User) {
        viewModelScope.launch {
            userRepository.delete(user)
        }
    }
}
