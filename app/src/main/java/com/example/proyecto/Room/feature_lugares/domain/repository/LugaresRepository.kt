package com.example.proyecto.Room.feature_lugares.domain.repository

import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import kotlinx.coroutines.flow.Flow

interface LugaresRepository {

    fun getLugar(): Flow<List<Lugares>>

    suspend fun getLugaresById(id: Int): Lugares?

    suspend fun insertLugares(user: Lugares)

    suspend fun deleteLugares(user: Lugares)
}