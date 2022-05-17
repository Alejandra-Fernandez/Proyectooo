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
fun FavoritosCard(title: String,subtitle:String, idImage:Int,idIcon:ImageVector,onItemClick:(categoria: Categoria)->Unit
){
    Card (
        modifier= Modifier
            .padding(20.dp),
        shape = RoundedCornerShape(10.dp),
    ){
        Row(
            verticalAlignment=Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier=Modifier.fillMaxWidth().padding(end = 5.dp),
        ) {
            Row(
                verticalAlignment=Alignment.CenterVertically
            ){
                val image : Painter = painterResource (id = idImage)
                Image(
                    painter = image, contentDescription = "",
                    modifier = Modifier.size(100.dp),
                    contentScale = ContentScale.Crop)

                Column(modifier=Modifier.padding(start = 3.dp)) {
                    Text(
                        text = title,
                        style = MaterialTheme.typography.h5.copy(fontWeight=FontWeight.Bold))
                    Text(
                        text = subtitle,
                        style = MaterialTheme.typography.subtitle1)


                }

        }
            TagCard(icon=idIcon)




        }

    }

}