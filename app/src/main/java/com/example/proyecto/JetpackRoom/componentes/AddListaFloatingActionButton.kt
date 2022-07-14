package com.example.proyecto.JetpackRoom.componentes

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.example.proyecto.JetpackRoom.core.Constants.Companion.ADD_LISTA


@Composable
fun AddListaFloatingActionButton(
    openDialog: () -> Unit
) {
    FloatingActionButton(
        onClick = {
            openDialog()
        },
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = ADD_LISTA
        )
    }
}