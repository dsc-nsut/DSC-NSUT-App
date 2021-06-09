package com.dscnsut.app.members

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.dscnsut.app.R


class MemberDetailsFragment : Fragment() {

    val safeArgs : MemberDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val member = safeArgs.member

        val view =  inflater.inflate(R.layout.fragment_member_details, container, false)

        return view

    }

}