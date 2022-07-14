package com.example.proyecto.JetpackRoom

import com.example.proyecto.JetpackRoom.model.Lista
import kotlinx.coroutines.flow.Flow


interface ListaRepository {
    suspend fun getListasFromRoom(): Flow<List<Lista>>

    suspend fun getListaFromRoom(id: Int): Flow< Lista>

    suspend fun addListaToRoom(lista:  Lista)

    suspend fun updateListaInRoom(lista:  Lista)

    suspend fun deleteListaFromRoom(lista:  Lista)
}