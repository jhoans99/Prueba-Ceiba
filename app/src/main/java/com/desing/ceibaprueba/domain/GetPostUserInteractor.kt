package com.desing.ceibaprueba.domain

import com.desing.ceibaprueba.data.model.PostUserModel
import com.desing.ceibaprueba.data.model.UserModel
import com.desing.ceibaprueba.data.model.repository.UserRepository
import javax.inject.Inject

class GetPostUserInteractor @Inject constructor(
    val repository: UserRepository
) {

    suspend operator fun invoke(id: String):List<PostUserModel>? = repository.getAllPostUser(id)

}