package com.example.proyecto.JetpackRoom.updateLista

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto.fragment.ListaViewModel

@Composable
fun UpdateListaScreen(
    listaId: Int,
    navigateToListasScreen: () -> Unit,
    viewModel: ListaViewModel = hiltViewModel()
) {
    LaunchedEffect(Unit) {
        viewModel.getLista(listaId)
    }
    Scaffold(
        topBar = {
            UpdateListaTopBar(
                navigateToListasScreen = navigateToListasScreen
            )
        },
        content = { padding ->
            UpdateListaContent(
                padding = padding,
                listaId = listaId,
                navigateToListasScreen = navigateToListasScreen
            )
        }
    )
}