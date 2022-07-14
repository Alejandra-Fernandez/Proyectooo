package com.example.proyecto.JetpackRoom.componentes

import android.provider.ContactsContract.CommonDataKinds.Organization.TITLE
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.AlertDialog
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.unit.dp
import com.example.proyecto.JetpackRoom.core.Constants.Companion.ADD
import com.example.proyecto.JetpackRoom.core.Constants.Companion.ADD_LISTA
import com.example.proyecto.JetpackRoom.core.Constants.Companion.CAPITAL
import com.example.proyecto.JetpackRoom.core.Constants.Companion.DEPARTAMENTO
import com.example.proyecto.JetpackRoom.core.Constants.Companion.DESCRIPCION
import com.example.proyecto.JetpackRoom.core.Constants.Companion.DISMISS
import com.example.proyecto.JetpackRoom.core.Constants.Companion.HABITANTES
import com.example.proyecto.JetpackRoom.core.Constants.Companion.SUPERFICIE
import com.example.proyecto.JetpackRoom.model.Lista
import kotlinx.coroutines.job


@Composable
fun AddListaAlertDialog(
    closeDialog: () -> Unit,
    addLista: (lista: Lista) -> Unit
) {
    var departamento by remember { mutableStateOf("") }
    var capital by remember { mutableStateOf("") }
    var descripcion by remember { mutableStateOf("") }
    var superficie by remember { mutableStateOf("") }
    var habitantes by remember { mutableStateOf("") }

    val focusRequester = FocusRequester()

    AlertDialog(
        onDismissRequest = {
            closeDialog()
        },
        title = {
            Text(
                text = ADD_LISTA
            )
        },
        text = {
            Column {
                TextField(
                    value = departamento,
                    onValueChange = { departamento = it },
                    placeholder = {
                        Text(
                            text = DEPARTAMENTO
                        )
                    },
                    modifier = Modifier.focusRequester(focusRequester)
                )
                LaunchedEffect(Unit) {
                    coroutineContext.job.invokeOnCompletion {
                        focusRequester.requestFocus()
                    }
                }
                Spacer(
                    modifier = Modifier.height(16.dp)
                )
                TextField(
                    value = capital,
                    onValueChange = { capital = it },
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
                    onValueChange = { descripcion = it },
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
                    onValueChange = { superficie = it },
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
                    onValueChange = { habitantes = it },
                    placeholder = {
                        Text(
                            text = HABITANTES
                        )
                    }
                )
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    closeDialog()
                    val lista = Lista(0, departamento, capital, descripcion, superficie, habitantes)
                    addLista(lista)
                }
            ) {
                Text(
                    text = ADD
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    closeDialog()
                }
            ) {
                Text(
                    text = DISMISS
                )
            }
        }
    )
}