package com.example.proyecto.Room.feature_lugares.presentation.edit

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.Room.feature_lugares.presentation.edit.components.LugaresInputText
import com.example.proyecto.ui.theme.ProyectoTheme
import kotlinx.coroutines.flow.collectLatest

@Composable
fun EditScreen(
    navController: NavController,
    viewModel: EditViewModel = hiltViewModel()
) {
    val departamentoState = viewModel.departamento.value
    val capitalState = viewModel.capital.value
    val superficieState = viewModel.superficie.value
    val habitantesState = viewModel.habitantes.value

    LaunchedEffect(key1 = true) {
        viewModel.eventFlow.collectLatest { event ->
            when (event) {
                is EditViewModel.UiEvent.SaveLugares -> {
                    navController.navigateUp()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            EditTopBar(
                topAppBarText = stringResource(id = R.string.add_lugares)
            )
        },
        content = {
            EditContent(
                departamento = departamentoState.text,
                capital = capitalState.text,
                superficie = superficieState.text,
                habitantes = habitantesState.text,
                onEvent = { viewModel.onEvent(it) }
            )
        },
        bottomBar = {
            EditBottomBar(
                onInsertLugares = { viewModel.onEvent(EditEvent.InsertLugares) }
            )
        }
    )
}

@Composable
fun EditTopBar(topAppBarText: String) {
    TopAppBar(
        title = {
            Text(
                text = topAppBarText,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            )
        },
        backgroundColor = MaterialTheme.colors.surface
    )
}

@Composable
fun EditContent(
    departamento: String,
    capital: String,
    superficie: String,
    habitantes: String,
    onEvent: (EditEvent) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(44.dp))
       LugaresInputText(
            text = departamento,
            hint = stringResource(id = R.string.departamento),
            onTextChange = { onEvent(EditEvent.EnteredDepartamento(it)) }
        )
        LugaresInputText(
            text = capital,
            hint = stringResource(id = R.string.capital),
            onTextChange = { onEvent(EditEvent.EnteredCapital(it)) }
        )
        LugaresInputText(
            text = superficie,
            hint = stringResource(id = R.string.superficie),
            onTextChange = { onEvent(EditEvent.EnteredSuperficie(it)) }
        )
        LugaresInputText(
            text = habitantes,
            hint = stringResource(id = R.string.habitantes),
            onTextChange = { onEvent(EditEvent.EnteredHabitantes(it)) }
        )
    }
}

@Composable
fun EditBottomBar(
    modifier: Modifier = Modifier,
    onInsertLugares: () -> Unit
) {
    Button(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 14.dp),
        onClick = { onInsertLugares() }
    ) {
        Text(text = stringResource(id = R.string.add_lugares))
    }
}

@Preview
@Composable
fun PreviewAddEditLugaresTopBar() {
    ProyectoTheme {
        EditTopBar(
            topAppBarText = stringResource(id = R.string.add_lugares)
        )
    }
}

@Preview
@Composable
fun PreviewAddEditLugaresContent() {
    ProyectoTheme {
        EditContent(
            departamento = "Amazonas",
            capital = "Chachapoyas",
            superficie = "39249",
            habitantes = "379384",
            onEvent = { }
        )
    }
}

@Preview
@Composable
fun PreviewAddEditBottomBar() {
    ProyectoTheme {
        EditBottomBar {}
    }
}