package com.desing.ceibaprueba.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.desing.ceibaprueba.R
import com.desing.ceibaprueba.data.model.PostUserModel
import com.desing.ceibaprueba.databinding.ActivityMainBinding
import com.desing.ceibaprueba.databinding.ActivityPostUserBinding
import com.desing.ceibaprueba.ui.view.common.components.AdapterCustomItemPosts
import com.desing.ceibaprueba.ui.viewmodel.PostUserViewModel
import com.desing.ceibaprueba.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PostUserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPostUserBinding
    private val postUserViewModel: PostUserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle :Bundle ?=intent.extras
        val idConsult = bundle!!.getString("id")

        postUserViewModel.onCreate(idConsult!!)

        postUserViewModel.listPostUser.observe(this, Observer {
            val adapterPost = AdapterCustomItemPosts(
                listPost = it
            )
            binding.AcPostRecyclerViewPost.layoutManager = LinearLayoutManager(this)
            binding.AcPostRecyclerViewPost.adapter = adapterPost
        })

        postUserViewModel.isLoading.observe(this, Observer {
            binding.AcPostLoadingSpinner.isVisible = it
        })
    }
}