package com.example.proyecto.component.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.R
import com.example.proyecto.model.Categoria
import com.example.proyecto.model.Region
import com.example.proyecto.screen.Section


@Composable
fun CategoriaCard(
    categoria: Categoria, onItemClick:(categoria: Categoria)->Unit
){
    Card (
        modifier= Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .clickable { onItemClick(categoria) },
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp
    ){
        Column(verticalArrangement=Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier=Modifier.fillMaxWidth(),){
            val image: Painter = painterResource(id = categoria.image)
            Image(painter = image, contentDescription = "",
                modifier = Modifier.height(150.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop)

            Text(
                text = categoria.category,
                style = MaterialTheme.typography.subtitle1.copy(fontWeight=FontWeight.Bold))


        }

    }

}