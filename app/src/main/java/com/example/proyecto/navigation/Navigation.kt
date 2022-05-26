package com.example.proyecto.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import androidx.navigation.NavType

import com.example.proyecto.screen.LoginScreen
import com.example.proyecto.screen.SignUpScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.proyecto.fragment.CategoriasFragment
import com.example.proyecto.fragment.OrderCardFragment
import com.example.proyecto.fragment.ProfileFragment
import com.example.proyecto.fragment.RegionsFragment
import com.example.proyecto.screen.HomeScreen
import com.example.proyecto.screen.Section


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
    ){
        composable(route = "detail/{Nombre}"){
            ConfigurationFragment(navController)
        }
        composable(route = "profile/{Nombre}", arguments = listOf(navArgument("Nombre"){type=
            NavType.StringType})){ backStackEntry ->
            val id = backStackEntry.arguments?.getString("Nombre")
            requireNotNull(id)
            ProfileFragment(nombre = id, navController = navController)
        }
        composable(Screen.LoginScreen.route){
            LoginScreen(navController)
        }
        composable(Screen.SignUpScreen.route){
            SignUpScreen(navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }

    }


}

@Composable
fun ConfigurationFragment(navController: NavHostController) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(){
        Text(text = "Nombre:")
        TextField(
            value = text,
            onValueChange = {newText ->
                text = newText},
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { navController.navigate("profile/${text.text}")}) {
            Text(text = "Confirmar")
        }
    }



}

