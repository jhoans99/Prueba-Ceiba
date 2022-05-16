package com.desing.ceibaprueba.data.model.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
   @PrimaryKey(autoGenerate = true)
   @ColumnInfo(name = "id_custom") val idAutoIncrement: Int = 0,
   @ColumnInfo(name = "id") val idUser: Int? = 0,
   @ColumnInfo(name = "name") val name: String? = "",
   @ColumnInfo(name = "username") val username: String? = "",
   @ColumnInfo(name = "email") val email: String? = "",
   @ColumnInfo(name = "phone") val phone: String? = ""
)
