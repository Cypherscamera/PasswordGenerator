package com.example.passgenerator.Data.Update

import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.passgenerator.Data.UserPass
import com.example.passgenerator.Data.UserViewModel
import com.example.passgenerator.R
import kotlinx.android.synthetic.main.fragment_addpassword.*
import kotlinx.android.synthetic.main.fragment_updatepassword.*
import kotlinx.android.synthetic.main.fragment_updatepassword.view.*

class updatepassword : Fragment() {

    val viewmodel : UserViewModel by viewModels()
private val args by navArgs<updatepasswordArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_updatepassword, container, false)

        view.editusername.setText(args.currentitem.username)
        view.editpassword.setText(args.currentitem.password)
        view.editwebsite.setText(args.currentitem.website)

        setHasOptionsMenu(true)

        view.update.setOnClickListener{
            updatedata()
        }
        view.generate.setOnClickListener{
            val ALPHA_NUMERIC = ('0'..'9') + ('A'..'Z') + ('a'..'z')+("@")+"#"+"*"
            val length = 12
            val resultpass = (1..length)
                .map { ALPHA_NUMERIC.random() }
                .joinToString("")
            editpassword.setText(resultpass)
        }
        return view
    }

    private fun updatedata() {

        val username = editusername.text.toString()
        val website = editwebsite.text.toString()
        val password = editpassword.text.toString()

        val updateduser = UserPass(args.currentitem.id, username, password, website)
        viewmodel.updateuser(updateduser)
        Toast.makeText(context, "Updated", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_updatepassword3_to_mainlist3)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delmenu, menu )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.delete){
            deluser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deluser(){
        val builder = AlertDialog.Builder(requireContext())
            .setPositiveButton("Yes"){_,_ ->
                viewmodel.deleteuser(args.currentitem)
                Toast.makeText(
                    requireContext(), "Deleted", Toast.LENGTH_SHORT
                ).show()
                findNavController().navigate(R.id.action_updatepassword3_to_mainlist3)
        }
        .setNegativeButton("No"){_,_ ->}
        .setTitle("Delete ${args.currentitem.username}?")
         .setMessage("Are you sure you want to delete ${args.currentitem.username}")
         .create().show()


    }


}