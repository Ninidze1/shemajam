package com.example.shemajamebeli

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.shemajamebeli.databinding.FragmentUserBinding

class UserFragment : Fragment() {

    private lateinit var binding: FragmentUserBinding

    companion object {

        const val REQUEST_CODE = 35

    }

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
            startActivity(Intent(context, UserActivity::class.java))
//            intent.putExtra("newPerson",updatedUser)
//            setResult(Activity.RESULT_OK, intent)
//            finish()

        }
    }

}