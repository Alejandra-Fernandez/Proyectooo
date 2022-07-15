package com.example.proyecto.fragment


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyRow
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
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.component.card.TagCard
import com.example.proyecto.model.Categoria
import com.example.proyecto.screen.Section
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.example.proyecto.component.card.RegionCard
import com.example.proyecto.model.Producto
import com.example.proyecto.model.Region


@Composable
fun RegionsFragment(navController: NavController){
    val regions = Region().getRegiones()
    LazyColumn{
        item{
            Spacer(modifier = Modifier.padding(2.dp))
            Slides()
            Spacer(modifier = Modifier.padding(4.dp))
            Categories()
        }
        items(regions){
            RegionCard(it,
                onItemClick = {
                    //CategoriasFragment(navController)

                })
        }
    }

}
@Preview
@OptIn(ExperimentalPagerApi::class)
@Composable
fun Slides() {
    val images = listOf(
        R.drawable.letras,
        R.drawable.costa1,
        R.drawable.sierra1,
        R.drawable.selva1,

        )
    val pagerState = rememberPagerState()

    HorizontalPager(
        state = pagerState,
        count = images.size,
        modifier = Modifier.height(150.dp)
    ){
            page->
        Image(painter = painterResource(id = images[page]), contentDescription = "",
            modifier = Modifier
                .padding(5.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Crop)

    }

}

@Preview
@Composable
fun Categories(){
    val categories = Categoria().getCategories()
    Column{
        Text(text = buildAnnotatedString {
            withStyle(
                style= SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            ){
                append("¿Estas buscando mas lugares? \n")
            }
            withStyle(
                style= SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp
                )
            ){
                append("Selecciona una ciudad")
            }
        },
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(10.dp))
        LazyRow {
            items(categories){
                TagCard(it.category)}

            }
        }
    }
