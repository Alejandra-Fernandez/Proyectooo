package com.example.proyecto.JetpackRoom.componentes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.proyecto.fragment.ListaViewModel


@Composable
@ExperimentalMaterialApi
fun ListaContent(
    padding: PaddingValues,
    navigateToUpdateListaScreen: (listaId: Int) -> Unit,
    viewModel: ListaViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier.fillMaxSize().padding(padding)
    ) {
        LazyColumn {
            items(
                items = viewModel.listas
            ) { lista ->
                ListaCard(
                    lista = lista,
                    deleteLista = {
                        viewModel.deleteLista(lista)
                    },
                    navigateToUpdateListaScreen = navigateToUpdateListaScreen
                )
            }
        }
    }
}