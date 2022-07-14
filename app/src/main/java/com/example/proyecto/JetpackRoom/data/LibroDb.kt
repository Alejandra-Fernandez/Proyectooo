package com.example.proyecto.JetpackRoom.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto.JetpackRoom.model.Lista


@Database(entities = [Lista::class], version = 1, exportSchema = false)
abstract class LibroDb : RoomDatabase() {
    abstract fun listaDao(): ListaDao
}