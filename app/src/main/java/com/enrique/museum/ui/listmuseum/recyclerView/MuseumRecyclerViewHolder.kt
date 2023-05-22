package com.enrique.museum.ui.listmuseum.recyclerView

import android.content.DialogInterface.OnClickListener
import androidx.recyclerview.widget.RecyclerView
import com.enrique.museum.data.model.MuseumModel
import com.enrique.museum.databinding.MuseumItemBinding

class MuseumRecyclerViewHolder(private val binding: MuseumItemBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(museum: MuseumModel, clickListener: (MuseumModel) -> Unit) {
        binding.nameTextView.text = museum.name
        binding.ubicationTextView.text = museum.ubication

        binding.museumItemCardView.setOnClickListener {
            clickListener(museum)
        }
    }
}