package com.example.contactcard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contactcard.data.cardData
import com.example.contactcard.databinding.ItemCardBinding

class cardAdapter : ListAdapter<cardData, cardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCardBinding.inflate(inflater, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: cardData) {
            binding.nome.text = item.nome
            binding.telefone.text = item.tel
            binding.email.text = item.email
            //binding.cdContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            /*binding.cdContent.setOnClickListener {
                listenerShare(it)
            }*/
        }
    }

}

class DiffCallback : DiffUtil.ItemCallback<cardData>() {
    override fun areItemsTheSame(oldItem: cardData, newItem: cardData) = oldItem == newItem
    override fun areContentsTheSame(oldItem: cardData, newItem: cardData) =
        oldItem.id == newItem.id
}