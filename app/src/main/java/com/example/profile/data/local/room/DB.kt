package com.example.profile.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.profile.data.local.room.dao.UserDao
import com.example.profile.data.local.room.entity.UserRegister

@Database(
    entities = [
        UserRegister::class
    ],
    version = 1
)
abstract class DB : RoomDatabase() {
    abstract fun daoUser(): UserDao
}
