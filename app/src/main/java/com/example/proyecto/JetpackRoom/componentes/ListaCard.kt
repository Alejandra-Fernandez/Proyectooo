package com.example.proyecto.JetpackRoom.componentes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.JetpackRoom.core.Constants.Companion.DELETE_LISTA
import com.example.proyecto.JetpackRoom.model.Lista


@Composable
@ExperimentalMaterialApi
fun ListaCard(
    lista: Lista,
    deleteLista: () -> Unit,
    navigateToUpdateListaScreen: (listaId: Int) -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 4.dp,
                bottom = 4.dp
            )
            .fillMaxWidth(),
        elevation = 3.dp,
        onClick = {
            navigateToUpdateListaScreen(lista.id)
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(all = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(0.90f)
            ) {
                Text(
                    text = lista.departamento,
                    color = MaterialTheme.colors.primary,
                    fontSize = 25.sp
                )
                Text(
                    text = "Capital: ${lista.capital}",
                    color = Color.White,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "Descripcion: ${lista.descripcion}",
                    color = Color.White,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "Superficie: ${lista.superficie}",
                    color = Color.White,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
                Text(
                    text = "Habitantes: ${lista.habitantes}",
                    color = Color.White,
                    fontSize = 12.sp,
                    textDecoration = TextDecoration.Underline
                )
            }
            IconButton(
                onClick = {
                    deleteLista()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = DELETE_LISTA,
                    tint = MaterialTheme.colors.primary
                )
            }
        }
    }
}
