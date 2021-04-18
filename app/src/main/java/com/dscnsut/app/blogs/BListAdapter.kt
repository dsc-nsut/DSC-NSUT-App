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

    override fun onBindViewHolder(holder: BListVHolder, position: Int) {
        val ci = mutableBlogList[position]

        holder.tv1.text = ci.title
        holder.tv2.text = ci.timestamp.toString()
        holder.tv3.text = ci.author

    }

    override fun getItemCount(): Int {
        return mutableBlogList.size
    }

    inner class BListVHolder(itemView : View) : RecyclerView.ViewHolder(itemView),
    View.OnClickListener{

        val imgV : ImageView = itemView.findViewById(R.id.image_v_blist)
        val tv1 : TextView = itemView.findViewById(R.id.tv_blist)
        val tv2 : TextView = itemView.findViewById(R.id.tv_date)
        val tv3 : TextView = itemView.findViewById(R.id.brief)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.onItemClick(mutableBlogList[adapterPosition])
            }

        }
    }
    interface OnItemClickListener{
        fun onItemClick(blog : BlogsModel)
    }
}

