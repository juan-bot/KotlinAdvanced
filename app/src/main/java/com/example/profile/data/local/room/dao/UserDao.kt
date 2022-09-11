package com.example.profile.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.profile.data.local.room.entity.UserRegister

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userRegister: UserRegister)

    // @Query("SELECT * From UserRegister WHERE user = :userParameter")
    // suspend fun getUser(userParameter: String): String
/*
    @Query("SELECT * FROM User")
    suspend fun getUser(): List<UserLogin>

    @Query("SELECT name FROM user WHERE user = :userParameter")
    suspend fun getName(userParameter: String): String

    @Query("DELETE FROM user")
    suspend fun deleteUser()*/
/*
    @Query("UPDATE user SET password = :newPassword WHERE user = :userParameter")
    suspend fun update(newPassword: String, userParameter: String): String*/
}
