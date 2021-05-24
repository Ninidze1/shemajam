package com.example.shemajamebeli

import android.os.Bundle
import android.util.Log
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shemajamebeli.databinding.RecycleFragmentBinding

class RecyclerFragment : Fragment() {

    private lateinit var binding: RecycleFragmentBinding
    private lateinit var adapter: ItemAdapter
    private var items = mutableListOf<ItemModel>()

    companion object {
        const val REQUEST_CODE = 35
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RecycleFragmentBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    private fun init() {

        adapter = ItemAdapter(items, object : onListener {

            override fun onRemoveListener(count: Int) {
                items.removeAt(count)
                adapter.notifyItemRemoved(count)
                adapter.notifyItemRangeChanged(count, items.size)
                Log.d("text0", "")

            }

            override fun onUpdateListener(count: Int) {

                findNavController().navigate(R.id.action_recyclerFragment_to_userFragment)
                val newUser = RecyclerFragmentArgs.fromBundle(requireArguments()).userInfo

            }

        })

        for (i in 0..4) {
            items.add(ItemModel("Gela", "Halliday", "ninidze@gmail.com"))
            items.add(ItemModel("Avtuliko", "Mackay", "ninidze@gmail.com"))
            items.add(ItemModel("Sandreqsa", "Wade", "ninidze@gmail.com"))
            items.add(ItemModel("Artura ", "Mosley", "ninidze@gmail.com"))
            items.add(ItemModel("Anton ", "Pitt", "ninidze@gmail.com"))
        }

        binding.recycleView.layoutManager = LinearLayoutManager(context)
        binding.recycleView.adapter = adapter
    }

}