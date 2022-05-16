package com.desing.ceibaprueba.data.model.repository

import com.desing.ceibaprueba.data.model.PostUserModel
import com.desing.ceibaprueba.data.model.UserModel
import com.desing.ceibaprueba.data.model.database.entities.UserEntity
import com.desing.ceibaprueba.data.model.database.entities.dao.UserDao
import com.desing.ceibaprueba.data.model.network.UserNetworking
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserNetworking,
    private val userDao : UserDao
) {
    suspend fun getAllUsersNetworking(): List<UserModel>{
        val response = api.getUser()
        return response
    }

    suspend fun getAllUsersDatabase(): List<UserModel>{
        val responseDatabase = userDao.getAllUser()
        return responseDatabase.map { UserModel(it.idUser,it.name,it.username,it.email,it.phone) }
    }

    suspend fun insertAllUser(userList:List<UserEntity>){
        userDao.insertAll(userList)
    }

    suspend fun getAllPostUser(id: String): List<PostUserModel>{
        return api.getPost(id)
    }
}