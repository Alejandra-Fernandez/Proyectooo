package com.example.proyecto.JetpackRoom.updateLista

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import com.example.proyecto.JetpackRoom.core.Constants.Companion.BACK
import com.example.proyecto.JetpackRoom.core.Constants.Companion.UPDATE_LISTA_SCREEN


@Composable
fun UpdateListaTopBar(
    navigateToListasScreen: () -> Unit
) {
    TopAppBar (
        title = {
            Text(
                text = UPDATE_LISTA_SCREEN
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {
                    navigateToListasScreen()
                }
            ) {
                Icon(
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = BACK,
                )
            }
        }
    )
}