package com.desing.ceibaprueba.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.desing.ceibaprueba.data.model.PostUserModel
import com.desing.ceibaprueba.domain.GetPostUserInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostUserViewModel @Inject constructor(
    private val getPostUserInteractor : GetPostUserInteractor
) : ViewModel() {

    val listPostUser = MutableLiveData<List<PostUserModel>>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate(idConsult: String) {
        isLoading.postValue(true)
        viewModelScope.launch {
            val result = getPostUserInteractor(idConsult)
            listPostUser.postValue(result!!)
            isLoading.postValue(false)
        }
    }
}