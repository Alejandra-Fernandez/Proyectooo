package com.example.proyecto.JetpackRoom.data

import androidx.room.*
import androidx.room.OnConflictStrategy.IGNORE
import com.example.proyecto.JetpackRoom.core.Constants.Companion.LISTA_TABLE
import com.example.proyecto.JetpackRoom.model.Lista
import kotlinx.coroutines.flow.Flow


@Dao
interface ListaDao {
    @Query("SELECT * FROM $LISTA_TABLE ORDER BY id ASC")
    fun getListas(): Flow<List<Lista>>

    @Query("SELECT * FROM $LISTA_TABLE WHERE id = :id")
    fun getLista(id: Int): Flow<Lista>

    @Insert(onConflict = IGNORE)
    fun addLista(lista: Lista)

    @Update
    fun updateLista(lista: Lista)

    @Delete
    fun deleteLista(lista: Lista)
}