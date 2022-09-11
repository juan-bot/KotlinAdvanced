package com.example.profile.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.profile.data.local.room.dao.LoginDao
import com.example.profile.data.local.room.dao.UserDao
import com.example.profile.data.local.room.entity.UserLogin
import com.example.profile.data.local.room.entity.UserRegister

@Database(
    entities = [
        UserRegister::class,
        UserLogin::class
    ],
    version = 1
)
abstract class DB : RoomDatabase() {
    abstract fun daoUser(): UserDao
    abstract fun daoLogin(): LoginDao
}
