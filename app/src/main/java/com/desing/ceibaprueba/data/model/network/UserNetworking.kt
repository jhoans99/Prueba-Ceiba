package com.desing.ceibaprueba.data.model.network

import com.desing.ceibaprueba.data.model.PostUserModel
import com.desing.ceibaprueba.data.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserNetworking @Inject constructor(
    private val api: UserApiClient
) {

    suspend fun getUser():List<UserModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllUsers()
            response.body() ?: emptyList()
        }
    }

    suspend fun getPost(id: String):List<PostUserModel>{
        return  withContext(Dispatchers.IO){
            val response = api.getAllPostUser(id)
            response.body() ?: emptyList()
        }
    }
}