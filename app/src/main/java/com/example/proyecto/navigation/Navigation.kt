package com.example.proyecto.navigation

import androidx.compose.runtime.Composable

import com.example.proyecto.screen.LoginScreen
import com.example.proyecto.screen.SignUpScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.proyecto.screen.HomeScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
    ){
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
