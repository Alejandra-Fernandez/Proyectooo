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
import com.example.proyecto.JetpackRoom.updateLista.UpdateListaScreen
import com.example.proyecto.Paging3.model.search.SearchScreen
import com.example.proyecto.fragment.CategoriasView
import com.example.proyecto.fragment.OrderCardFragment
import com.example.proyecto.screen.HomeScreen
@ExperimentalCoilApi
@ExperimentalPagingApi
@ExperimentalMaterialApi
@Composable
fun Navigation(navController: NavController){
   val navController = rememberNavController()
    //val categoriaView = CategoriasView()
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

        composable(route = Screen.SearchScreen.route){
            SearchScreen(navController)
        }

        //Room
        composable(route = Screen.OrderCardFragment.route) {
            OrderCardFragment(navigateToUpdateListaScreen = { listaId ->
                navController.navigate(Screen.UpdateListaScreen.route + "/${listaId}")
            })
        }
        composable(route = Screen.UpdateListaScreen.route + "/{listaId}", arguments = listOf(navArgument("listaId") {
            type = NavType.IntType
        }
        )
        ) { backStackEntry ->
            val listaId = backStackEntry.arguments?.getInt("listaId") ?: 0
            UpdateListaScreen(
                listaId = listaId,
                navigateToListasScreen = {
                    navController.popBackStack()
                }
            )
        }

    }


}
