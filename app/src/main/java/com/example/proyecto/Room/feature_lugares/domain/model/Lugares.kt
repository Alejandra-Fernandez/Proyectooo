package com.example.proyecto.Room.feature_lugares.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Lugares(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val departamento: String,
    @ColumnInfo(name = "capital") val capital: String,
    val superficie: Int,
    val habitantes: Int
)
