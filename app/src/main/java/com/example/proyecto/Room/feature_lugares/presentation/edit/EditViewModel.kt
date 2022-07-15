package com.example.proyecto.Room.feature_lugares.presentation.edit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.Room.feature_lugares.domain.use_cases.GetLugares
import com.example.proyecto.Room.feature_lugares.domain.use_cases.InsertLugares
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class EditViewModel @Inject constructor(
    private val getLugares: GetLugares,
    private val insertLugares: InsertLugares,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _departamento = mutableStateOf(TextFieldState())
    val departamento: State<TextFieldState> = _departamento

    private val _capital = mutableStateOf(TextFieldState())
    val capital: State<TextFieldState> = _capital

    private val _superficie = mutableStateOf(TextFieldState())
    val superficie: State<TextFieldState> = _superficie

    private val _habitantes = mutableStateOf(TextFieldState())
    val habitantes: State<TextFieldState> = _habitantes

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var currentLugaresId: Int? = null

    init {
        savedStateHandle.get<Int>("lugaresId")?.let { lugaresId ->
            if (lugaresId != -1) {
                viewModelScope.launch {
                    getLugares(lugaresId)?.also { lugares ->
                        currentLugaresId = lugares.id
                        _departamento.value = departamento.value.copy(
                            text = lugares.departamento
                        )
                        _capital.value = capital.value.copy(
                            text = lugares.capital
                        )
                        _superficie.value = superficie.value.copy(
                            text = lugares.superficie.toString()
                        )
                        _habitantes.value = habitantes.value.copy(
                            text = lugares.habitantes.toString()
                        )
                    }
                }
            }
        }
    }

    fun onEvent(event: EditEvent) {
        when (event) {
            is EditEvent.EnteredDepartamento -> {
                _departamento.value = departamento.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredCapital -> {
                _capital.value = capital.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredSuperficie -> {
                _superficie.value = superficie.value.copy(
                    text = event.value
                )
            }
            is EditEvent.EnteredHabitantes -> {
                _habitantes.value = habitantes.value.copy(
                    text = event.value
                )
            }
            EditEvent.InsertLugares -> {
                viewModelScope.launch {
                    insertLugares(
                        Lugares(
                            departamento = departamento.value.text,
                            capital = capital.value.text,
                            superficie = superficie.value.text.toInt(),
                            habitantes = habitantes.value.text.toInt(),
                            id = currentLugaresId
                        )
                    )
                    _eventFlow.emit(UiEvent.SaveLugares)
                }
            }
        }
    }

    sealed class UiEvent {
        object SaveLugares: UiEvent()
    }
}