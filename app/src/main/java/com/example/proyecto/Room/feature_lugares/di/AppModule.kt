package com.example.proyecto.Room.feature_lugares.di

import android.app.Application
import androidx.room.Room
import com.example.proyecto.Room.feature_lugares.data.local.LugaresDatabase
import com.example.proyecto.Room.feature_lugares.data.local.repository.LugaresRepositoryImpl
import com.example.proyecto.Room.feature_lugares.domain.repository.LugaresRepository
import com.example.proyecto.Room.feature_lugares.utils.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLugaresDatabase(app: Application) = Room.databaseBuilder(
        app,
        LugaresDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Provides
    @Singleton
    fun provideRepository(db: LugaresDatabase): LugaresRepository {
        return LugaresRepositoryImpl(db.lugaresDao)
    }
}