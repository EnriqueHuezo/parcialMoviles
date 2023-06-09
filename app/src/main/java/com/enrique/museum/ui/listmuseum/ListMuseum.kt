package com.enrique.museum.ui.listmuseum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.enrique.museum.R
import com.enrique.museum.data.model.MuseumModel
import com.enrique.museum.databinding.FragmentAddMuseumBinding
import com.enrique.museum.databinding.FragmentListMuseumBinding
import com.enrique.museum.ui.listmuseum.recyclerView.MuseumRecyclerViewAdapter
import com.enrique.museum.ui.viewmodel.MuseumViewModel

class ListMuseum : Fragment() {

    private val museumViewModel: MuseumViewModel by activityViewModels {
        MuseumViewModel.Factory
    }

    private lateinit var binding: FragmentListMuseumBinding

    private lateinit var adapter: MuseumRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListMuseumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView(view)

        binding.floatingActionButton.setOnClickListener {
            museumViewModel.clearData()
            it.findNavController().navigate(R.id.action_listMuseum_to_addMuseum)
        }
    }

    private fun showSelectedItem(museum: MuseumModel) {
        museumViewModel.setSelectedMuseum(museum)
        findNavController().navigate(R.id.action_listMuseum_to_infoMuseum)
    }

    // RecyclerView

    private fun displayMuseums() {
        adapter.setData(museumViewModel.getMuseums())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View) {
        binding.reciclerViewMuseums.layoutManager = LinearLayoutManager(view.context)

        adapter = MuseumRecyclerViewAdapter { selectedMuseum ->
            showSelectedItem(selectedMuseum)
        }

        binding.reciclerViewMuseums.adapter = adapter
        displayMuseums()
    }
}