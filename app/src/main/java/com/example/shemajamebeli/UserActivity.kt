package com.example.shemajamebeli

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UserActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private var items = mutableListOf<ItemModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        init()
    }

    private fun init() {

        adapter = ItemAdapter(items, object: ClickListener {
            override fun updateClickListener(position: Int) {
                startActivity(Intent(baseContext, UsersActivity::class.java))
            }

            override fun removeClickListener(position: Int) {
                items.removeAt(position)
                adapter.notifyItemRemoved(position)            }

        })

        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))
        items.add(ItemModel("giorgi", "ninidze", "ninidze@gmail.com"))

        recyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

}