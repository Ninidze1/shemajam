package com.example.shemajamebeli

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(
    private val items: MutableList<ItemModel>, private val itemClickListener: ClickListener
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private var nameEditText: TextView = itemView.findViewById(R.id.nameEditText)
        private var lastNameEditText: TextView = itemView.findViewById(R.id.lastNameEditText)
        private var EmailEditText: TextView = itemView.findViewById(R.id.emailEditText)
        private var idEditText: TextView = itemView.findViewById(R.id.idEditText)
        private var updateButton: Button = itemView.findViewById(R.id.updateButton)
        private var deleteButton: Button = itemView.findViewById(R.id.deleteButton)


        fun bind() {
            val model = items[adapterPosition]
            nameEditText.text = model.name
            lastNameEditText.text = model.lastName
            EmailEditText.text = model.email
            idEditText.text = (adapterPosition.toInt() + 1).toString()

            updateButton.setOnClickListener{
                items.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

            deleteButton.setOnClickListener {
                items.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }

        }

        override fun onClick(clickedView: View?) {
            if (clickedView is ImageView)
            when (clickedView.id) {
                R.id.deleteButton -> itemClickListener.removeClickListener(adapterPosition)
                R.id.updateButton -> itemClickListener.updateClickListener(adapterPosition)

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind()

    }

    override fun getItemCount(): Int = items.size

}