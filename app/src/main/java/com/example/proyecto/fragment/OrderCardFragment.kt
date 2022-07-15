package com.example.proyecto.fragment

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.Room.feature_lugares.presentation.HomeEvent
import com.example.proyecto.Room.feature_lugares.presentation.HomeFab
import com.example.proyecto.Room.feature_lugares.presentation.LugaresViewModel
import com.example.proyecto.Room.feature_lugares.presentation.components.LugaresItem
import com.example.proyecto.navigation.Screen
import com.example.proyecto.ui.theme.ProyectoTheme


@Composable
fun OrderCardFragment(
    navController: NavController
) {
    val viewModel: LugaresViewModel = hiltViewModel()
    val state = viewModel.state.value

    Scaffold(

        floatingActionButton = {
            HomeFab(
                onFabClicked = { navController.navigate(Screen.Edit.route) }
            )
        },
        content = { innerPadding ->
            HomeContent(
                modifier = Modifier.padding(innerPadding),
                onDeleteLugares = { viewModel.onEvent(HomeEvent.DeleteLugares(it)) },
                onEditLugares = {
                    navController.navigate(
                        route = Screen.Edit.passId(it)
                    )
                },
                lugar = state.lugar
            )
        }
    )
}

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteLugares: (lugares: Lugares) -> Unit,
    onEditLugares: (id: Int?) -> Unit,
    lugar: List<Lugares> = emptyList()
) {
    Surface(

        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        LazyColumn {
            items(lugar) { lugares ->
                LugaresItem(
                    lugares = lugares,
                    onEditLugares = { onEditLugares(lugares.id) },
                    onDeleteLugares = { onDeleteLugares(lugares) }
                )
            }
        }
    }
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {  }
) {
    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_lugares))
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLugaresContent() {
    ProyectoTheme(darkTheme = false) {
        HomeContent(onDeleteLugares = {}, onEditLugares = {})
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLugaresFab() {
    ProyectoTheme(darkTheme = false) {
        HomeFab()
    }
}






/*
    val orders = Orden().getOrders()
    LazyColumn(Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween){
        items(orders){
            FavoritosCard(it.title,
                "Ciudad de ${it.count}",
                it.image,
                Icons.Default.Close,
                 onItemClick =  {

            }
            )

        }

    }*/