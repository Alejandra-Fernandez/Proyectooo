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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto.R
import com.example.proyecto.screen.Section


@Composable
fun TagCard(
   tag:String="", icon: ImageVector= Icons.Default.Add
){
   Card(backgroundColor = MaterialTheme.colors.primary,
   shape = RoundedCornerShape(12.dp),
   modifier = Modifier.padding(3.dp)){
       if(tag.isNotEmpty())
           Text(text = tag,
           modifier= Modifier.padding(12.dp,6.dp,12.dp,6.dp),
       color= MaterialTheme.colors.onPrimary)
       else
        Icon(icon,
        tint = MaterialTheme.colors.onPrimary,
        contentDescription = "",
        modifier = Modifier.padding(10.dp))
   }

}