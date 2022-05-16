package com.desing.ceibaprueba.ui.view.common.components

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.desing.ceibaprueba.R
import com.desing.ceibaprueba.data.model.PostUserModel

class AdapterCustomItemPosts(
    val listPost : List<PostUserModel>
): RecyclerView.Adapter<AdapterCustomItemPosts.ViewHolder>() {

    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val layoutInflater = LayoutInflater.from(context)
        return ViewHolder(
            layoutInflater.inflate(
                R.layout.item_card_posts,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listPost[position]
        holder.textBody.text = item.body
        holder.textTitle.text = item.title
    }

    override fun getItemCount(): Int {
        return listPost.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textTitle: TextView = view.findViewById(R.id.itemPost_card_title_tv)
        val textBody: TextView = view.findViewById(R.id.itemPost_body_tv)
    }
}