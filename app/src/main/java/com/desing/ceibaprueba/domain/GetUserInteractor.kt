package com.desing.ceibaprueba.domain

import com.desing.ceibaprueba.data.model.UserModel
import com.desing.ceibaprueba.data.model.database.entities.UserEntity
import com.desing.ceibaprueba.data.model.repository.UserRepository
import javax.inject.Inject


class GetUserInteractor @Inject constructor(
    private val repositoryUser: UserRepository
) {
    suspend operator fun invoke():List<UserModel>?{
        val userList = repositoryUser.getAllUsersDatabase()

       return if(userList.isNotEmpty()){
           userList
        }else{
            val userNetworking = repositoryUser.getAllUsersNetworking()
            repositoryUser.insertAllUser(userNetworking.map { UserEntity(idUser = it.id, name = it.name, username = it.username, email = it.email, phone = it.email) })
            userNetworking
        }
    }

    fun filterList(filter: CharSequence, list:List<UserModel>):List<UserModel>?{
        return list.filter { it.name?.lowercase()!!.contains(filter.toString().lowercase()) }
    }
}