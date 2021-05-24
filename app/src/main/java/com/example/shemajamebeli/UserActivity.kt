package com.example.shemajamebeli

import android.content.Intent
import android.os.Bundle
import android.util.Log.d
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli.databinding.ActivityUserBinding
import com.example.shemajamebeli.databinding.RecycleViewBinding

class UserActivity : AppCompatActivity() {

    private lateinit var adapter: ItemAdapter
    private lateinit var binding: RecycleViewBinding
    private lateinit var binding2: ActivityUserBinding
    private var items = mutableListOf<ItemModel>()

    companion object {
        const val REQUEST_CODE = 35
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = RecycleViewBinding.inflate(layoutInflater)
        binding2 = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()

    }

    private fun addFragment() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {

            val newUser = data?.getParcelableExtra<ItemModel>("newPerson")
            val count = data?.getIntExtra("count", 0)
//
            if (newUser != null && count != null) {
                items[count] = newUser
                adapter.notifyItemChanged(count)
            }
            d("datacheck", "$newUser")
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun init() {

        adapter = ItemAdapter(items, object : onListener {

            override fun onRemoveListener(count: Int) {
                items.removeAt(count)
                adapter.notifyItemRemoved(count)
                adapter.notifyItemRangeChanged(count, items.size)
                d("text0", "")

            }

            override fun onUpdateListener(count: Int) {
                binding2.navHostFragment
//                val intent = Intent(this@UserActivity, UserFragment::class.java)
//                intent.putExtra("count", count)
//                startActivityForResult(intent, REQUEST_CODE)

            }

        })

        for (i in 0..4) {
            items.add(ItemModel("Gela", "Halliday", "ninidze@gmail.com"))
            items.add(ItemModel("Avtuliko", "Mackay", "ninidze@gmail.com"))
            items.add(ItemModel("Sandreqsa", "Wade", "ninidze@gmail.com"))
            items.add(ItemModel("Artura ", "Mosley", "ninidze@gmail.com"))
            items.add(ItemModel("Anton ", "Pitt", "ninidze@gmail.com"))
        }

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
    }
}