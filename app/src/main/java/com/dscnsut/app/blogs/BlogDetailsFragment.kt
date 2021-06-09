package com.dscnsut.app.blogs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.dscnsut.app.R

class fragment_blogDetails : Fragment() {


    val safeArgs : fragment_blogDetailsArgs by navArgs()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val blog = safeArgs.blog

        val view = inflater.inflate(R.layout.fragment_blog_details, container, false)
        view.findViewById<TextView>(R.id.BlogHeader).setText(blog.title)
        view.findViewById<TextView>(R.id.BlogCreator).setText(blog.author)
        view.findViewById<TextView>(R.id.BlogDate).setText(blog.timestamp.toString())
        view.findViewById<TextView>(R.id.BlogBody).setText(blog.body)


        return view
    }
}