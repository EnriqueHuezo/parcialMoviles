package com.enrique.museum.data

import com.enrique.museum.data.model.MuseumModel

val name = "Museo Marte"
val ubication = "San Salvador, Avenida la Libertad, calle 245 "

val name2 = "Museo nacional de El Salvador"
val ubication2 = "San Salvador, centro historico de San Salvador"

val museums = mutableListOf(
    MuseumModel(name, ubication),
    MuseumModel(name2, ubication2)
)