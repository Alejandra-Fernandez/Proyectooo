package com.example.proyecto.fragment

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto.JetpackRoom.ListaRepository
import com.example.proyecto.JetpackRoom.model.Lista
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ListaViewModel @Inject constructor(
    private val repo: ListaRepository
) : ViewModel() {
    var listas by mutableStateOf(emptyList<Lista>())
    var lista by mutableStateOf(Lista(0, "", "","","",""))
    var isDialogOpen by mutableStateOf(false)

    fun getListas() = viewModelScope.launch {
        repo.getListasFromRoom().collect { response ->
            listas = response
        }
    }

    fun getLista(id: Int) = viewModelScope.launch {
        repo.getListaFromRoom(id).collect { response ->
            lista = response
        }
    }

    fun updateDepartamento(departamento: String) {
        lista = lista.copy(departamento = departamento)
    }

    fun updateCapital(capital: String) {
        lista = lista.copy(capital = capital)
    }
    fun updateDescripcion(descripcion: String) {
        lista = lista.copy(descripcion = descripcion)
    }

    fun updateSuperficie(superficie: String) {
        lista = lista.copy(superficie = superficie)
    }
    fun updateHabitantes(habitantes: String) {
        lista = lista.copy(habitantes = habitantes)
    }


    fun addLista(lista: Lista) = viewModelScope.launch(Dispatchers.IO) {
        repo.addListaToRoom(lista)
    }

    fun updateLista(lista: Lista) = viewModelScope.launch(Dispatchers.IO) {
        repo.updateListaInRoom(lista)
    }

    fun deleteLista(lista: Lista) = viewModelScope.launch(Dispatchers.IO) {
        repo.deleteListaFromRoom(lista)
    }
}