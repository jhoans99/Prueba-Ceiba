package com.desing.ceibaprueba.ui.view.common.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desing.ceibaprueba.R
import com.desing.ceibaprueba.data.model.UserModel

class AdapterCustomItemUser(
    private val listUser : List<UserModel>,
    private val goPost: ((UserModel) -> Unit)
): RecyclerView.Adapter<AdapterCustomItemUser.ViewHolder>() {

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_card_user, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listUser[position]
        holder.textName.text = item.name
        holder.textPhone.text = item.phone
        holder.textEmail.text = item.email

        holder.textButtonPosts.setOnClickListener {
            goPost(item)
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textName: TextView = view.findViewById(R.id.item_card_name_user_tv)
        val textPhone: TextView = view.findViewById(R.id.item_phone_user_tv)
        val textEmail: TextView = view.findViewById(R.id.item_email_user_tv)
        val textButtonPosts: TextView = view.findViewById(R.id.item_card_posts_user_button)
    }
}

