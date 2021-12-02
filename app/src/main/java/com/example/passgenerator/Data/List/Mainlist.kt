package com.example.passgenerator.Data.List

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passgenerator.Data.UserViewModel
import com.example.passgenerator.R
import kotlinx.android.synthetic.main.fragment_mainlist.*
import kotlinx.android.synthetic.main.fragment_mainlist.view.*

class Mainlist : Fragment() {

    val viewModel: UserViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_mainlist, container, false)

        val adapter = MainAdapter()
        val recycleview = view.recycle
        recycleview.adapter = adapter
        recycleview.layoutManager = LinearLayoutManager(requireContext())

        viewModel.readalldata.observe(viewLifecycleOwner,{user ->
            adapter.setdata(user)
        })
        view.floatingActionButton.setOnClickListener{

            findNavController().navigate(R.id.action_mainlist3_to_addpassword3)
        }

        return view
    }

}