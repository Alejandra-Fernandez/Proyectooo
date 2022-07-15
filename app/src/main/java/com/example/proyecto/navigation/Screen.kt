package com.example.proyecto.navigation


sealed class Screen(val route:String) {
    object LoginScreen: Screen("login_screen")
    object SignUpScreen: Screen("signup_screen")
    object HomeScreen: Screen("home_screen")
    object SearchScreen: Screen("search_screen")
    object OrderCardFragment: Screen("order")

    //room
    object Edit: Screen("edit?lugaresId={lugaresId}") {
        fun passId(lugaresId: Int?): String {
            return "edit?lugaresId=$lugaresId"
        }
    }

}