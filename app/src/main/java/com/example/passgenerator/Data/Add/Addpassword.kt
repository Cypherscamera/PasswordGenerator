package com.example.passgenerator.Data.Add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.passgenerator.Data.UserPass
import com.example.passgenerator.Data.UserViewModel
import com.example.passgenerator.R
import kotlinx.android.synthetic.main.fragment_addpassword.*
import kotlinx.android.synthetic.main.fragment_addpassword.view.*
import java.lang.StringBuilder

class Addpassword : Fragment() {

val viewmodel: UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_addpassword, container, false)

        view.save.setOnClickListener{
            addtodatabase()
        }
        view.generate.setOnClickListener{
             val ALPHA_NUMERIC = ('0'..'9') + ('A'..'Z') + ('a'..'z')+("@")+"#"+"*"
            val length = 12
            val resultpass = (1..length)
                .map { ALPHA_NUMERIC.random() }
                .joinToString("")
            password.setText(resultpass)
        }

        return view
    }

    private fun addtodatabase() {
        val username = username.text.toString()
        val password = password.text.toString()
        val website = website.text.toString()
        val user = UserPass(0,username, password, website)
        viewmodel.adduser(user)
        Toast.makeText(requireContext(), "Success", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_addpassword3_to_mainlist3)
    }
}