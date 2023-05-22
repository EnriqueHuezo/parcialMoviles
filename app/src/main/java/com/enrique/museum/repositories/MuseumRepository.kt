package com.enrique.museum.repositories

import com.enrique.museum.data.model.MuseumModel

class MuseumRepository(private val museums: MutableList<MuseumModel>) {
    fun getMuseums() = museums
    fun addMuseum(museum: MuseumModel) = museums.add(0, museum)
}