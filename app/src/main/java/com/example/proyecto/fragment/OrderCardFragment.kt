package com.example.proyecto.fragment


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.navigation.NavController
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OrderCardFragment(navController:NavController){
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

    }

}
