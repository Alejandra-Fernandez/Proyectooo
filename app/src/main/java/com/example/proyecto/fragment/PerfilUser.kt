package com.example.proyecto.fragment

import androidx.compose.runtime.Composable
import androidx.navigation.NavController

/*
import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.navigation.NavController
import com.example.proyecto.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

@SuppressLint("FlowOperatorInvokedInComposition")
@OptIn(ExperimentalUnitApi::class)
*/

@Composable
fun PerfilUser(navController: NavController) {}
/*
    val context = LocalContext.current
    val userNameKey = stringPreferencesKey("user_name")
    val userEmailKey = stringPreferencesKey("user_email")
    val userPhoneKey = stringPreferencesKey("user_phone")

    val userName : Flow<String?> = context.dataStore.data.map {
                preferences ->
            preferences[userNameKey] ?: ""
        }

/*
    val user = flow<String> {
        context.dataStore.data.map {
            it[userNameKey]
        }.collect(collector = {
            if (it != null) {
                this.emit(it)
            }
        })

    }.collectAsState(initial = "")*/


     // to save the email
    /* suspend fun saveName(name: String) {
         context.dataStore.edit { preferences ->
             preferences[userNameKey] = name
         }
     }*/


    Column(
        modifier = Modifier
            .fillMaxWidth(), horizontalAlignment = Alignment.Start
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text ="Nombre: "+userName,
            fontSize = TextUnit(18F, TextUnitType.Sp),
            color = Color.Magenta,
        )
        Text(
            text ="Correo: "+userEmailKey,
            fontSize = TextUnit(18F, TextUnitType.Sp),
            color = Color.Magenta,
        )
        Text(
            text ="Telefono: "+userPhoneKey,
            fontSize = TextUnit(18F, TextUnitType.Sp),
            color = Color.Magenta,
        )

        Spacer(modifier = Modifier.height(2.dp))


    }

}*/