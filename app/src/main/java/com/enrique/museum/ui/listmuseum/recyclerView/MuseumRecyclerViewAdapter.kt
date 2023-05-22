package com.enrique.museum.ui.listmuseum.recyclerView

import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.enrique.museum.data.model.MuseumModel
import com.enrique.museum.databinding.MuseumItemBinding

class MuseumRecyclerViewAdapter(
    private val clickListener: (MuseumModel) -> Unit
) : RecyclerView.Adapter<MuseumRecyclerViewHolder>() {

    private val museums = ArrayList<MuseumModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MuseumRecyclerViewHolder {
        val binding = MuseumItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MuseumRecyclerViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return museums.size
    }

    override fun onBindViewHolder(holder: MuseumRecyclerViewHolder, position: Int) {
        val museum = museums[position]
        holder.bind(museum, clickListener)
    }

    fun setData(museumList: List<MuseumModel>) {
        museums.clear()
        museums.addAll(museumList)
    }

}