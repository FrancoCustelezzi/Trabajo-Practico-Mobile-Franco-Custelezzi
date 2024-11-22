package com.example.tp1francodayana.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tp1francodayana.TpDesaMobileApp

@Database(entities = [User::class], version = 3, exportSchema = false)
abstract class TP1DB : RoomDatabase() {

    abstract fun userDao(): UserDAO

    companion object {
        @Volatile
        private var INSTANCE: TP1DB? = null

        fun getDatabase(): TP1DB {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }

            return INSTANCE ?:synchronized(this) {
                val instance = Room.databaseBuilder(
                    TpDesaMobileApp.instance.applicationContext,
                    TP1DB::class.java,
                    "TP1DB"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
