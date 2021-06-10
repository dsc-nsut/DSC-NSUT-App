package com.dscnsut.app.members

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.dscnsut.app.R


class MemberDetailsFragment : Fragment() {

    val safeArgs : MemberDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val member = safeArgs.member

        val view =  inflater.inflate(R.layout.fragment_member_details, container, false)

        view.findViewById<TextView>(R.id.MemberName).text = member.name
        view.findViewById<TextView>(R.id.MemberIntro).text = member.intro

        //load profile photo

        val profilephoto = view.findViewById<ImageView>(R.id.MemberProfilePic)
        val MemberPicurl = member.picName

        Glide.with(this).load(MemberPicurl).placeholder(R.drawable.ic_launcher_foreground).error(R.drawable.ic_launcher_foreground).into(profilephoto)

        //Buttons
        val githubButton = view.findViewById<Button>(R.id.githubButton)
        val linkedinButton = view.findViewById<Button>(R.id.linkedinButton)
        val instaButton = view.findViewById<Button>(R.id.instaButton)
        val twitterButton = view.findViewById<Button>(R.id.twitterButton)

        //listeners on social media buttons

        val intent = Intent(Intent.ACTION_VIEW)

        githubButton.setOnClickListener {

            val githublink : String = member.github!!
            intent.data = Uri.parse(githublink)
            startActivity(intent)
        }

        linkedinButton.setOnClickListener {

            val linkedinlink : String = member.linkedin!!
            intent.data = Uri.parse(linkedinlink)
            startActivity(intent)
        }

        instaButton.setOnClickListener {

            val instalink : String = member.instagram!!
            intent.data = Uri.parse(instalink)
            startActivity(intent)
        }

        twitterButton.setOnClickListener {

            val twitterlink : String = member.twitter!!
            intent.data = Uri.parse(twitterlink)
            startActivity(intent)
        }


        return view

    }

}