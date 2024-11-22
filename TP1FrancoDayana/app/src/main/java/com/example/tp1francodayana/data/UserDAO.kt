package com.example.tp1francodayana.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDAO {

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>> //getAll

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user: User) //insert

    @Update
    fun update(user: User) //update

    @Delete
    abstract fun deleteUser(user: User) //delete un usuario

    @Query("DELETE FROM user_table")
    fun deleteAll() //delete todos

    @Query("SELECT * FROM user_table WHERE mail =:mail")
    fun getUserById(mail:String) : User

    @Delete
    suspend fun delete(user: User)
}
