package com.example.proyecto.fragment

import androidx.lifecycle.ViewModel
import androidx.paging.ExperimentalPagingApi
import com.example.proyecto.Paging3.model.data.remote.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@ExperimentalPagingApi
@HiltViewModel
class CategoriasView @Inject constructor(
    repository: Repository
): ViewModel() {
    val getAllImages = repository.getAllImages()
}