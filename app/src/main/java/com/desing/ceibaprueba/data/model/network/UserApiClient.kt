package com.desing.ceibaprueba.data.model.network

import com.desing.ceibaprueba.data.model.PostUserModel
import com.desing.ceibaprueba.data.model.UserModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiClient {
    @GET("users")
    suspend fun getAllUsers():Response<List<UserModel>>

    @GET("posts")
    suspend fun getAllPostUser(
        @Query("userId") id: String
    ):Response<List<PostUserModel>>
}