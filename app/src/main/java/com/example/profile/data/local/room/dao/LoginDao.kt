package com.example.profile.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.profile.data.local.room.entity.UserRegister

@Dao
interface LoginDao {
    @Query("SELECT * From Userlogin WHERE user = :userParameter")
    suspend fun getName(userParameter: String): String

    @Insert
    suspend fun insertUser(userRegister: UserRegister)
}
