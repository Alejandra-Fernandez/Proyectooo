package com.example.proyecto.fragment



import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
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




