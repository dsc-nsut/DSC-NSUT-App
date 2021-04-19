package com.dscnsut.app.blogs

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.dscnsut.app.R
import java.util.*

class BListAdapter(private val listener : OnItemClickListener): RecyclerView.Adapter<BListAdapter.BListVHolder>()  {
    var mutableBlogList = mutableListOf<BlogsModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BListVHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.bloglist_layout,parent,false)

        return BListVHolder(itemView)
    }

    override fun onBindViewHolder(holder: BListVHolder, position: Int){
        val ci = mutableBlogList[position]

        holder.tvTitle.text = ci.title
        holder.tvDate.text = ci.timestamp.toString()
        holder.tvAuthor.text = ci.author

        holder.cardView.setOnClickListener() {
            listener.onItemClick(ci)
        }

        fun onClick(v: View?) {
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(mutableBlogList[position])
            }

        }

    }

    override fun getItemCount(): Int {
        return mutableBlogList.size
    }

    inner class BListVHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val imgV : ImageView = itemView.findViewById(R.id.image_v_blist)
        val tvTitle : TextView = itemView.findViewById(R.id.tv_blist)
        val tvDate : TextView = itemView.findViewById(R.id.tv_date)
        val tvAuthor : TextView = itemView.findViewById(R.id.brief)
        val cardView : CardView = itemView.findViewById(R.id.cardView)

    }
    interface OnItemClickListener{
        fun onItemClick(blog : BlogsModel)
    }
}

