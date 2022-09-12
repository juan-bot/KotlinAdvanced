package com.example.profile.data.local.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.profile.data.local.room.DBConstant

@Entity(tableName = DBConstant.TB_NAME_USER)
data class UserRegister(
    @PrimaryKey
    @ColumnInfo(name = "user")
    val user: String,

    @ColumnInfo(name = "name")
    val name: String = "",

    @ColumnInfo(name = "lastName")
    val lastName: String = "",

    @ColumnInfo(name = "secondLastName")
    val secondLastName: String = "",

    @ColumnInfo(name = "birthday")
    val birthday: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "genre")
    val genre: String,

    @ColumnInfo(name = "state")
    val state: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "password")
    val password: String
)
