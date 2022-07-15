package com.example.proyecto.Room.feature_lugares.data.local.repository

import com.example.proyecto.Room.feature_lugares.data.local.LugaresDao
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.Room.feature_lugares.domain.repository.LugaresRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LugaresRepositoryImpl  @Inject constructor(
    private val dao: LugaresDao
): LugaresRepository {
    override fun getLugar(): Flow<List<Lugares>> {
        return dao.getLugar()
    }

    override suspend fun getLugaresById(id: Int): Lugares? {
        return dao.getLugaresById(id)
    }

    override suspend fun insertLugares(lugares: Lugares) {
        dao.insertLugares(lugares)
    }

    override suspend fun deleteLugares(lugares: Lugares) {
        dao.deleteLugares(lugares)
    }
}