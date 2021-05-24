//package com.example.shemajamebeli
//
//import android.app.Activity
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.LayoutInflater
//import com.example.shemajamebeli.databinding.ActivityUsersBinding
//
//class UsersActivity : AppCompatActivity() {
//
//    private lateinit var binding: ActivityUsersBinding
//    private var userList = mutableListOf<ItemModel>()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityUsersBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        init()
//
//    }
//
//    private fun init() {
//
//        binding.saveButton.setOnClickListener {
//
//            val name = binding.nameEditText.text.toString()
//            val lastName = binding.lastNameEditText.text.toString()
//            val email = binding.emailEditText.text.toString()
//
//            val updatedUser = ItemModel(name , lastName, email)
//            userList.add(updatedUser)
//            intent.putExtra("newPerson",updatedUser)
//            setResult(Activity.RESULT_OK, intent)
//            finish()
//
//        }
//    }
//}