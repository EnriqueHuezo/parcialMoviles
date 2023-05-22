package com.enrique.museum.ui

import android.app.Application
import com.enrique.museum.data.museums
import com.enrique.museum.repositories.MuseumRepository

class MuseumReviewerApplication: Application() {
    val museumRepository: MuseumRepository by lazy {
        MuseumRepository(museums)
    }
}