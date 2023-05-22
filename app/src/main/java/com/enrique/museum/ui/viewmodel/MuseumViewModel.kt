package com.enrique.museum.ui.viewmodel

import android.text.Spannable.Factory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.enrique.museum.data.model.MuseumModel
import com.enrique.museum.repositories.MuseumRepository
import com.enrique.museum.ui.MuseumReviewerApplication

class MuseumViewModel(private val repository: MuseumRepository): ViewModel() {
    var name = MutableLiveData("")
    var ubication = MutableLiveData("")
    var status = MutableLiveData("")

    fun getMuseums() = repository.getMuseums()
    fun addMuseum(museum: MuseumModel) = repository.addMuseum(museum)

    // Funciones principales

    fun createMuseum() {
        if (validateData()) {
            status.value = SOMETHING_WRONG
            return
        }

        val museum = MuseumModel(
            name.value!!,
            ubication.value!!
        )

        addMuseum(museum)
        clearData()

        status.value = MUSEUM_CREATED
    }

    fun setSelectedMuseum(museum: MuseumModel) {
        name.value = museum.name
        ubication.value = museum.ubication
    }

    // Funciones de validacion y limpieza de datos

    private fun validateData(): Boolean {
        when {
            name.value.isNullOrEmpty() -> return true
            ubication.value.isNullOrEmpty() -> return true
        }
        return false
    }

    fun clearData() {
        name.value = ""
        ubication.value = ""
    }

    fun clearStatus() {
        status.value = INACTIVE
    }

    // Factory

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as MuseumReviewerApplication
                MuseumViewModel(app.museumRepository)
            }
        }

        const val MUSEUM_CREATED = "Museum added"
        const val SOMETHING_WRONG = "Something is wrong"
        const val INACTIVE = ""

    }
}