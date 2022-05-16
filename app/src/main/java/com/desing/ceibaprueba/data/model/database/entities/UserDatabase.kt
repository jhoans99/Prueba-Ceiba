package com.desing.ceibaprueba.data.model.database.entities

import androidx.room.Database
import androidx.room.RoomDatabase
import com.desing.ceibaprueba.data.model.database.entities.dao.UserDao

@Database(entities = [UserEntity::class], version = 1)
abstract class UserDatabase: RoomDatabase() {

    abstract fun getUserDao(): UserDao
}