package com.example.profile.data.local.room

import android.content.Context
import androidx.room.Room

class DataBase(private val context: Context) {
    private var dataBase: DB? = null
    suspend fun createDatabase() {
        dataBase = Room.databaseBuilder(context, DB::class.java, DBConstant.DB_NAME)
            .allowMainThreadQueries().build()
        // fallbackToDestructiveMigration()
        if (!dataBase!!.isOpen) {
            val pathDB = dataBase!!.openHelper.writableDatabase
            println("DB PATH: $pathDB")
        }
    }
    suspend fun getDB(): DB {
        if (dataBase == null) {
            createDatabase()
        }
        return dataBase!!
    }
}
