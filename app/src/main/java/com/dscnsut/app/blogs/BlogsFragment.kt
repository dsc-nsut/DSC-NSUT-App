package com.dscnsut.app.blogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dscnsut.app.events.EventsFragment
import com.dscnsut.app.R

class BlogsFragment : Fragment() , BListAdapter.OnItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val blogView = inflater.inflate(R.layout.fragment_blogs, container, false)

        val viewModel = ViewModelProvider(this).get(BlogsViewModel::class.java)
        viewModel.getBlogs()

        val recyclerView = blogView.findViewById<RecyclerView>(R.id.recycler_view)

        val BlistAdapter = BListAdapter(this)

        viewModel.blogs.observe(viewLifecycleOwner, {blogList ->
            if(blogList == null){
                println("Empty")
            }
            else{
                BlistAdapter.mutableBlogList=blogList
                BlistAdapter.notifyDataSetChanged()
            }
        })



        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = BlistAdapter

        return blogView

    }

    override fun onItemClick(blog: BlogsModel) {
        findNavController().navigate(BlogsFragmentDirections.actionBlogsFragmentToFragmentBlogDetails(blog))
    }


}


