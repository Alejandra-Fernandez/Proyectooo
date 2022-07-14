package com.example.proyecto.Paging3.model.data.remote.local.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyecto.Paging3.model.UnsplashImage
import com.example.proyecto.Paging3.model.UnsplashRemoteKeys


@Database(entities = [UnsplashImage::class, UnsplashRemoteKeys::class], version = 1)
abstract class UnsplashDatabase : RoomDatabase() {

    abstract fun unsplashImageDao(): UnsplashImageDao
    abstract fun unsplashRemoteKeysDao(): UnsplashRemoteKeysDao

}