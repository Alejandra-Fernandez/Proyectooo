package com.example.proyecto.Room.feature_lugares.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares


@Database(
    entities = [Lugares::class],
    version = 1,
    exportSchema = false
)
abstract class LugaresDatabase: RoomDatabase() {
    abstract val lugaresDao: LugaresDao
}