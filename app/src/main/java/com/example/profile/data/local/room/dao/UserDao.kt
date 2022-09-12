package com.example.profile.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.profile.data.local.room.entity.UserRegister

@Dao
interface UserDao {
    @Insert
    suspend fun insertUser(userRegister: UserRegister)

    @Query("SELECT * FROM UserRegister WHERE user = :userParameter AND password = :passParameter")
    suspend fun getUser(userParameter: String, passParameter: String): UserRegister

    @Query("SELECT * FROM UserRegister WHERE user = :userParameter")
    suspend fun getUserProfile(userParameter: String): UserRegister

    @Query("DELETE FROM UserRegister")
    suspend fun deleteUser()

    @Query("SELECT * FROM UserRegister")
    suspend fun getUsers(): UserRegister
}
