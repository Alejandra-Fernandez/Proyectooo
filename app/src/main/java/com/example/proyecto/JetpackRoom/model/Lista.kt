package com.example.proyecto.JetpackRoom.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.proyecto.JetpackRoom.core.Constants.Companion.LISTA_TABLE


@Entity(tableName = LISTA_TABLE)
data class Lista(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val departamento: String,
    val capital: String,
    val descripcion: String,
    val superficie: String,
    val habitantes: String
)