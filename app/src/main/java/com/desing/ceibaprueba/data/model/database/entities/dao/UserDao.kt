package com.desing.ceibaprueba.data.model.database.entities.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.desing.ceibaprueba.data.model.database.entities.UserEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    suspend fun getAllUser():List<UserEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(user: List<UserEntity>)
}