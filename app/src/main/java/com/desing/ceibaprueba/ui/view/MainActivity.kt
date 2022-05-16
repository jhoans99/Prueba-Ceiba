package com.desing.ceibaprueba.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.desing.ceibaprueba.data.model.UserModel
import com.desing.ceibaprueba.databinding.ActivityMainBinding
import com.desing.ceibaprueba.ui.view.common.components.AdapterCustomItemUser
import com.desing.ceibaprueba.ui.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val userViewModel: UserViewModel by viewModels()
    private var listUserFilter : List<UserModel>? = emptyList()
    private var listUser : List<UserModel>? = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listeners()

        userViewModel.onCreate()
        userViewModel.userModelList.observe(this, Observer {
            listUser = it
            loadAdapter(it)
        })
        userViewModel.isLoading.observe(this, Observer {
            binding.AcMainLoadingSpinner.isVisible = it
        })
    }

    private fun listeners(){
        binding.AcMainSearchRecyclerViewUser.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val lisFilter = userViewModel.filterRecyclerView(s,listUser!!)
                if(lisFilter.isNotEmpty()){
                    binding.AcMainRecyclerViewUser.isVisible = true
                    binding.AcMainTextviewEmptylist.isVisible = false
                    loadAdapter(lisFilter)
                }else{
                    binding.AcMainRecyclerViewUser.isVisible = false
                    binding.AcMainTextviewEmptylist.isVisible = true
                }

            }

            override fun afterTextChanged(s: Editable?) {
                if(s.toString().isEmpty()){
                    loadAdapter(listUser!!)
                }
            }

        } )
    }

    private fun loadAdapter(list: List<UserModel>){
        val adapterCustomItemUser = AdapterCustomItemUser(
            listUser = list,
            goPost = { itemSelect ->
                val idSelected: String = itemSelect.id.toString()
                val intent = Intent(this, PostUserActivity::class.java)
                intent.putExtra("id", idSelected)
                startActivity(intent)
            }
        )
        binding.AcMainRecyclerViewUser.layoutManager = LinearLayoutManager(this)
        binding.AcMainRecyclerViewUser.adapter = adapterCustomItemUser
    }

}