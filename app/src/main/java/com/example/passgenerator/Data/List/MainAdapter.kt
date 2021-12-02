package com.example.passgenerator.Data.List

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.passgenerator.Data.UserPass
import com.example.passgenerator.R
import kotlinx.android.synthetic.main.items.view.*
import kotlin.coroutines.coroutineContext

class MainAdapter : RecyclerView.Adapter<MainAdapter.viewholder>() {

    var userlist : List<UserPass> = emptyList<UserPass>()
    class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        return viewholder(LayoutInflater.from(parent.context).inflate(R.layout.items, parent, false))
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        val item = userlist[position]

        holder.itemView.idea.text =item.id.toString()
        holder.itemView.username.text = item.username
        holder.itemView.website.text = item.website
        holder.itemView.password.text = item.password
        holder.itemView.clickforupdate.setOnClickListener{
            val action =MainlistDirections.actionMainlist3ToUpdatepassword3(item)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
    fun setdata(user: List<UserPass>){
        this.userlist = user
        notifyDataSetChanged()
    }
}