package com.example.proyecto.JetpackRoom.updateLista

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto.JetpackRoom.core.Constants.Companion.CAPITAL
import com.example.proyecto.JetpackRoom.core.Constants.Companion.DEPARTAMENTO
import com.example.proyecto.JetpackRoom.core.Constants.Companion.DESCRIPCION
import com.example.proyecto.JetpackRoom.core.Constants.Companion.HABITANTES
import com.example.proyecto.JetpackRoom.core.Constants.Companion.SUPERFICIE
import com.example.proyecto.JetpackRoom.core.Constants.Companion.UPDATE
import com.example.proyecto.JetpackRoom.model.Lista
import com.example.proyecto.fragment.ListaViewModel


@Composable
fun UpdateListaContent(
    padding: PaddingValues,
    listaId: Int,
    navigateToListasScreen: () -> Unit,
    viewModel: ListaViewModel = hiltViewModel()
) {
    val departamento = viewModel.lista.departamento
    val capital = viewModel.lista.capital
    val descripcion = viewModel.lista.descripcion
    val superficie = viewModel.lista.superficie
    val habitantes = viewModel.lista.habitantes

    Column(
        modifier = Modifier.fillMaxSize().padding(padding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = departamento,
            onValueChange = { departamento -> viewModel.updateDepartamento(departamento) },
            placeholder = {
                Text(
                    text = DEPARTAMENTO
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = capital,
            onValueChange = { capital -> viewModel.updateCapital(capital) },
            placeholder = {
                Text(
                    text = CAPITAL
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = descripcion,
            onValueChange = { descripcion -> viewModel.updateDescripcion(descripcion) },
            placeholder = {
                Text(
                    text = DESCRIPCION
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = superficie,
            onValueChange = { superficie -> viewModel.updateSuperficie(superficie) },
            placeholder = {
                Text(
                    text = SUPERFICIE
                )
            }
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        TextField(
            value = habitantes,
            onValueChange = { habitantes -> viewModel.updateHabitantes(habitantes) },
            placeholder = {
                Text(
                    text = HABITANTES
                )
            }
        )
        Button(
            onClick = {
                val updatedLista = Lista(listaId, departamento, capital, descripcion,  superficie,  habitantes)
                viewModel.updateLista(updatedLista)
                navigateToListasScreen()
            }
        ) {
            Text(
                text = UPDATE
            )
        }
    }
}