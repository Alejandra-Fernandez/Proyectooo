package com.example.proyecto.Room.feature_lugares.domain.use_cases

import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.Room.feature_lugares.domain.repository.LugaresRepository
import javax.inject.Inject

class DeleteLugares @Inject constructor(
    private val repository: LugaresRepository
) {
    suspend operator fun invoke(lugares: Lugares) {
        repository.deleteLugares(lugares)
    }
}