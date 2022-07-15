package com.example.proyecto.Room.feature_lugares.presentation.edit


sealed class EditEvent {
    data class EnteredDepartamento(val value: String): EditEvent()
    data class EnteredCapital(val value: String): EditEvent()
    data class EnteredSuperficie(val value: String): EditEvent()
    data class EnteredHabitantes(val value: String): EditEvent()
    object InsertLugares: EditEvent()
}