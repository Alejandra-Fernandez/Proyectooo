package com.example.proyecto.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyecto.R
import com.example.proyecto.component.*
import com.example.proyecto.navigation.Screen


@Composable
fun LoginScreen(naveController:NavController){
    val emailValue = remember {mutableStateOf("") }
    val passwordValue = remember {mutableStateOf("") }
    val passwordVisible = remember {mutableStateOf(false) }

    Scaffold(backgroundColor = MaterialTheme.colors.background){
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            item {
                Spacer(modifier = Modifier.padding(20.dp))
                LogoApp()
                Spacer(modifier = Modifier.padding(20.dp))
                TextFieldBase("Correo", emailValue)
                Spacer(modifier = Modifier.padding(20.dp))
                TextFieldPassword("ContraseÃ±a", passwordValue, passwordVisible)
                Spacer(modifier = Modifier.padding(20.dp))
                ButtonBase("Iniciar Sesion", onClick = {
                    naveController.navigate(Screen.HomeScreen.route) {
                        popUpTo(Screen.LoginScreen.route) {
                            inclusive = true

                        }
                    }
                })
                Spacer(modifier = Modifier.padding(20.dp))
                TextClick("Crear cuenta",onClick=  {
                    naveController.navigate(Screen.SignUpScreen.route){
                        popUpTo(Screen.LoginScreen.route){
                            inclusive=true

                        }
                    }
                })

            }

        }


    }
}
