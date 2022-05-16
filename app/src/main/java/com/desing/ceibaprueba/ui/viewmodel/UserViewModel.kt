package com.desing.ceibaprueba.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desing.ceibaprueba.data.model.UserModel
import com.desing.ceibaprueba.domain.GetUserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
    private val getUserInteractor : GetUserInteractor
) : ViewModel() {

    val userModelList = MutableLiveData<List<UserModel>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getUserInteractor()
            userModelList.postValue(result!!)
            isLoading.postValue(false)
        }
    }

    fun filterRecyclerView(s: CharSequence?,list: List<UserModel>):List<UserModel> {
        return getUserInteractor.filterList(s!!,list)!!
    }

}