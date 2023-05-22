package com.enrique.museum.ui.informationmuseum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.enrique.museum.R
import com.enrique.museum.databinding.FragmentAddMuseumBinding
import com.enrique.museum.databinding.FragmentInfoMuseumBinding
import com.enrique.museum.databinding.FragmentListMuseumBinding
import com.enrique.museum.ui.viewmodel.MuseumViewModel

class InfoMuseum : Fragment() {

    private val museumViewModel: MuseumViewModel by activityViewModels {
        MuseumViewModel.Factory
    }

    private lateinit var binding: FragmentInfoMuseumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInfoMuseumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
    }

    private fun setViewModel() {
        binding.viewmodel = museumViewModel
    }

}