package com.enrique.museum.ui.addmuseum

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.enrique.museum.databinding.FragmentAddMuseumBinding
import com.enrique.museum.ui.viewmodel.MuseumViewModel

class AddMuseum : Fragment() {

    private val museumViewModel: MuseumViewModel by activityViewModels {
        MuseumViewModel.Factory
    }

    private lateinit var binding: FragmentAddMuseumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddMuseumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewModel()
        observeStatus()
    }

    private fun setViewModel() {
        binding.viewmodel = museumViewModel
    }

    private fun observeStatus() {
        museumViewModel.status.observe(viewLifecycleOwner) {status ->
            when {
                status.equals(MuseumViewModel.SOMETHING_WRONG) -> {
                    Log.d("peto papito", status)
                    museumViewModel.clearStatus()
                }
                status.equals(MuseumViewModel.MUSEUM_CREATED) -> {
                    Log.d("se creo papito", status)
                    Log.d("te creo esto: ", museumViewModel.getMuseums().toString())

                    museumViewModel.clearStatus()
                    findNavController().popBackStack()
                }
            }
        }
    }

}