package com.example.shemajamebeli

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shemajamebeli.databinding.ItemLayoutBinding
import androidx.fragment.app.Fragment

class ItemAdapter( private val items: MutableList<ItemModel>,  private var click: onListener) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val model = items[adapterPosition]

            when (adapterPosition % 4) {
                0 -> binding.root.setBackgroundResource(R.drawable.ic_red_card)
                1 -> binding.root.setBackgroundResource(R.drawable.ic_orange_card)
                2 -> binding.root.setBackgroundResource(R.drawable.ic_blue_card)
                3 -> binding.root.setBackgroundResource(R.drawable.ic_green_card)
            }

            binding.nameTextView.text = model.name
            binding.lastNameTextView.text = model.lastName
            binding.emailTextView.text = model.email
            binding.IdTextView.text = (adapterPosition + 1).toString()

            binding.deleteButton.setOnClickListener {
                removeItem()
            }
            binding.updateButton.setOnClickListener {
                updateInfo()
            }

        }

        private fun updateInfo() {
            click.onUpdateListener(adapterPosition)
        }

        private fun removeItem()  {
            click.onRemoveListener(adapterPosition)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = items.size

}
