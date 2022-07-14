package com.example.proyecto.fragment


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.*
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.example.proyecto.R
import com.example.proyecto.component.card.CategoriaCard
import com.example.proyecto.component.card.TagCard
import com.example.proyecto.model.Categoria
import com.example.proyecto.screen.Section
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.example.proyecto.component.card.RegionCard
import com.example.proyecto.model.Region
import com.example.proyecto.screen.common.ListContent

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun CategoriasFragment(navController: NavController
) {
    val categoriasView: CategoriasView = hiltViewModel()
    val getAllImages = categoriasView.getAllImages.collectAsLazyPagingItems()

    Scaffold(
        content = {
            ListContent(items = getAllImages)
        }
    )

    /* val categories = Categoria().getCategories()
    LazyVerticalGrid(cells = GridCells.Fixed(2) ){
        items(categories){
            CategoriaCard(it, onItemClick = {

            }
            )*/

}




