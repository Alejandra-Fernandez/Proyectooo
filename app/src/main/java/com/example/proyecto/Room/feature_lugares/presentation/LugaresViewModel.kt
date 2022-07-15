package com.example.proyecto.Room.feature_lugares.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto.Room.feature_lugares.domain.use_cases.DeleteLugares
import com.example.proyecto.Room.feature_lugares.domain.use_cases.GetLugar
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LugaresViewModel @Inject constructor(
    private val deleteLugares: DeleteLugares,
    getLugar: GetLugar
): ViewModel() {

    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    init {
        getLugar().onEach {lugar ->
            _state.value = state.value.copy(
                lugar = lugar
            )
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.DeleteLugares -> {
                viewModelScope.launch {
                    deleteLugares(event.lugares)
                }
            }
        }
    }
}