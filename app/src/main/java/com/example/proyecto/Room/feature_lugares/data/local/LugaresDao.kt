package com.example.proyecto.Room.feature_lugares.data.local


import androidx.room.*
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import kotlinx.coroutines.flow.Flow



@Dao
interface LugaresDao {
    @Query("SELECT * FROM Lugares")
    fun getLugar(): Flow<List<Lugares>>

    @Query("SELECT * FROM Lugares WHERE id = :id")
    suspend fun getLugaresById(id: Int): Lugares?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertLugares(lugares: Lugares)

    @Delete
    suspend fun deleteLugares(Lugares: Lugares)
}