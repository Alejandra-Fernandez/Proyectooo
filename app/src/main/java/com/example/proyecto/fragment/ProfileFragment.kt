package com.example.proyecto.fragment

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

import com.example.proyecto.model.Orden

@Composable
fun ProfileFragment(nombre: String, navController: NavController){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(){
        Text(text = "Nombre: "+nombre)
        Button(onClick = { navController.navigate("detail/${text}")}) {
            Text(text = "Agregar")
        }


    }
}