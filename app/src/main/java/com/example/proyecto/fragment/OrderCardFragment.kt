package com.example.proyecto.fragment


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.proyecto.JetpackRoom.componentes.AddListaAlertDialog
import com.example.proyecto.JetpackRoom.componentes.AddListaFloatingActionButton
import com.example.proyecto.JetpackRoom.componentes.ListaContent
import com.example.proyecto.R
import com.example.proyecto.component.card.CategoriaCard
import com.example.proyecto.component.card.FavoritosCard
import com.example.proyecto.component.card.TagCard
import com.example.proyecto.model.Categoria
import com.example.proyecto.screen.Section
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.example.proyecto.component.card.RegionCard
import com.example.proyecto.model.Orden
import com.example.proyecto.model.Region

@ExperimentalMaterialApi
@Composable
fun OrderCardFragment(navigateToUpdateListaScreen: (listaId: Int) -> Unit){

    val viewModel: ListaViewModel = hiltViewModel()
    //val navigateToUpdateListaScreen: (listaId: Int) -> Unit

    val isDialogOpen = viewModel.isDialogOpen

    fun openDialog() {
        viewModel.isDialogOpen = true
    }
    fun closeDialog() {
        viewModel.isDialogOpen = false
    }

    LaunchedEffect(Unit) {
        viewModel.getListas()
    }
    Scaffold(

        floatingActionButton = {
            AddListaFloatingActionButton(
                openDialog = {
                    openDialog()
                }
            )
        },
        content = { padding ->
            ListaContent(
                padding = padding,
                navigateToUpdateListaScreen = navigateToUpdateListaScreen
            )
            if(isDialogOpen) {
                AddListaAlertDialog(
                    closeDialog = {
                        closeDialog()
                    },
                    addLista = { lista ->
                        viewModel.addLista(lista)
                    }
                )
            }
        }
    )
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