package com.example.proyecto.navigation

import com.example.proyecto.JetpackRoom.core.Constants.Companion.UPDATE_LISTA_SCREEN

enum class Screen(val route:String) {
    LoginScreen("login_screen"),
    SignUpScreen("signup_screen"),
    HomeScreen("home_screen"),
    SearchScreen("search_screen"),
    OrderCardFragment("order_screen"),
    UpdateListaScreen(UPDATE_LISTA_SCREEN)
}