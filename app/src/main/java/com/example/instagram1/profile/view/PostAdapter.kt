package com.example.instagram1.profile.view

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.instagram1.R
import common.view.Post


class PostAdapter: RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

        var items: List<Post> = mutableListOf()

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
            return PostViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_post_list,parent,false)
            )
        }

        override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
            holder.bind(items[position].uri)
        }

        override fun getItemCount(): Int {
            return items.size
        }
         class PostViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
            fun bind(image: Uri){
                itemView.findViewById<ImageView>(R.id.home_img_post).setImageURI(image)
            }
        }

    }
