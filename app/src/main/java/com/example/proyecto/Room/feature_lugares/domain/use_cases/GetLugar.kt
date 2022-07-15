package com.example.proyecto.Room.feature_lugares.domain.use_cases

import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.Room.feature_lugares.domain.repository.LugaresRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLugar @Inject constructor(
    private val repository: LugaresRepository
) {
    operator fun invoke(): Flow<List<Lugares>> {
        return repository.getLugar()
    }
}