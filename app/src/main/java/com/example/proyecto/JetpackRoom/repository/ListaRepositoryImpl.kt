package com.example.proyecto.JetpackRoom.repository

import com.example.proyecto.JetpackRoom.ListaRepository
import com.example.proyecto.JetpackRoom.data.ListaDao
import com.example.proyecto.JetpackRoom.model.Lista



class ListaRepositoryImpl(
    private val listaDao: ListaDao
) : ListaRepository {
    override suspend fun getListasFromRoom() = listaDao.getListas()

    override suspend fun getListaFromRoom(id: Int) = listaDao.getLista(id)

    override suspend fun addListaToRoom(lista: Lista) = listaDao.addLista(lista)

    override suspend fun updateListaInRoom(lista: Lista) = listaDao.updateLista(lista)

    override suspend fun deleteListaFromRoom(lista: Lista) = listaDao.deleteLista(lista)
}