package com.example.shemajamebeli

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.shemajamebeli.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding  = FragmentUserBinding.inflate(inflater, container, false)

        init()

        return binding.root

    }

    private fun init() {
        binding.saveButton.setOnClickListener {

            val name = binding.nameEditText.text.toString()
            val lastName = binding.lastNameEditText.text.toString()
            val email = binding.emailEditText.text.toString()

            val updatedUser = ItemModel(name , lastName, email)

            val action = UserFragmentDirections.actionUserFragmentToRecyclerFragment(updatedUser)
            d("gogogo", "$action")
            it.findNavController().navigate(action)

        }
    }

}