package com.example.proyecto.navigation
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType

import com.example.proyecto.screen.LoginScreen
import com.example.proyecto.screen.SignUpScreen
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.proyecto.Paging3.model.search.SearchScreen
import com.example.proyecto.Room.feature_lugares.presentation.edit.EditScreen
import com.example.proyecto.fragment.OrderCardFragment

import com.example.proyecto.screen.HomeScreen
@ExperimentalCoilApi
@ExperimentalPagingApi

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route,
    ) {
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController)
        }
        composable(Screen.SignUpScreen.route) {
            SignUpScreen(navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(route = Screen.SearchScreen.route) {
            SearchScreen(navController)
        }

        //room
        composable(Screen.OrderCardFragment.route) {
            OrderCardFragment(navController)
        }
        composable(
            route = Screen.Edit.route,
            arguments = listOf(
                navArgument(
                    name = "lugaresId"
                ) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) {
            EditScreen(navController = navController)
        }



    }
}