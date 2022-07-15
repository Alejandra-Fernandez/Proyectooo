package com.example.proyecto.Room.feature_lugares.presentation

import com.example.proyecto.Room.feature_lugares.domain.model.Lugares

data class HomeState(
    val lugar: List<Lugares> = emptyList()
)