package com.example.proyecto.JetpackRoom.dii

import android.content.Context
import androidx.room.Room
import com.example.proyecto.JetpackRoom.ListaRepository
import com.example.proyecto.JetpackRoom.core.Constants.Companion.LISTA_TABLE
import com.example.proyecto.JetpackRoom.data.LibroDb
import com.example.proyecto.JetpackRoom.data.ListaDao
import com.example.proyecto.JetpackRoom.repository.ListaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun provideListaDb(
        @ApplicationContext
        context : Context
    ) = Room.databaseBuilder(
        context,
        LibroDb::class.java,
        LISTA_TABLE
    ).build()

    @Provides
    fun provideListaDao(
        listaDb: LibroDb
    ) = listaDb.listaDao()

    @Provides
    fun provideListaRepository(
        listaDao: ListaDao
    ): ListaRepository = ListaRepositoryImpl(listaDao)
}