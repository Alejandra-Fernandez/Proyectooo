package com.example.proyecto.Room.feature_lugares.presentation

import com.example.proyecto.Room.feature_lugares.domain.model.Lugares


sealed class HomeEvent {
    data class DeleteLugares(val lugares: Lugares): HomeEvent()
}