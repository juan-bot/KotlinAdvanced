package com.example.profile.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.profile.data.local.room.DBConstant
@Entity(tableName = DBConstant.TB_NAME_LOGIN)
data class UserLogin(
    @PrimaryKey
    @ColumnInfo(name = "user")
    val user: String = ""
)
