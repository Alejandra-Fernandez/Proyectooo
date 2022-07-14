package com.example.proyecto.screen

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.ExperimentalPagingApi
import coil.annotation.ExperimentalCoilApi
import com.example.proyecto.Paging3.model.search.SearchScreen
import com.example.proyecto.R
import com.example.proyecto.component.*
import com.example.proyecto.fragment.*
import com.example.proyecto.navigation.Screen

@ExperimentalCoilApi
@ExperimentalPagingApi
@Composable
fun HomeScreen(naveController:NavController){
    val navItems = Section.values().toList()
    val section = remember{ mutableStateOf(Section.Regions)}

    val currentTheme = isSystemInDarkTheme()
    val toggleTheme:()->Unit={
        if(currentTheme) setDarkTheme()else setDayTheme()
    }
    val onSearchClicked: () -> Unit={
        naveController.navigate(Screen.SearchScreen.route)
    }




    Scaffold(backgroundColor = MaterialTheme.colors.background,
        modifier = Modifier.padding(15.dp),
        topBar = {
            Crossfade(targetState = section.value) {
                    section->
                when(section){
                    Section.Regions-> TopBarApp("Regiones del Peru", "Selecciona una region", R.drawable.ic_baseline_emoji_objects_24, onIconClick = toggleTheme)
                    Section.Explore-> TopBarApp("Busca lugares turisticos", "Selecciona una ciudad", R.drawable.ic_baseline_search_24, onIconClick = onSearchClicked)
                    Section.Favorites-> TopBarApp("Tus lugares favoritos", "Tus lugares mas visitados", R.drawable.ic_baseline_star_24, onIconClick = {})
                    Section.Profile-> TopBarApp("Perfil", "Datos personales", R.drawable.ic_baseline_exit_to_app_24, onIconClick = {})
                }

            }},

        bottomBar = {BottomBarApp(
            items  = navItems,
            currentSection = section.value,
            onSectionSelected = {section.value=it}

        )} ){
        innerPadding->
        Crossfade(
            modifier=Modifier.padding(innerPadding),
            targetState = section.value) {
                section->
            when(section){
                Section.Regions-> RegionsFragment(naveController)
                Section.Explore-> CategoriasFragment(naveController)
                Section.Favorites-> naveController.navigate(Screen.OrderCardFragment.route)
                Section.Profile-> PerfilUser(naveController) //ventana del perfil de usuario
            }

        }

    }

}



 private fun setDayTheme(){
     AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
 }

 private fun setDarkTheme(){
     AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
 }


enum class Section(val icon:Int){
 Regions(R.drawable.ic_baseline_home_24),
 Explore(R.drawable.ic_baseline_search_24),
 Favorites(R.drawable.ic_baseline_star_24),
 Profile(R.drawable.ic_baseline_person_24)
}