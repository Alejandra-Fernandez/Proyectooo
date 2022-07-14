package com.example.proyecto.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat

private val DarkColorPalette = darkColors(
    primary = primaryColor,
    onPrimary = white,
    background = backgroundDark,
    onBackground = white,
    surface = surfaceDark,
    onSurface = white,
)

private val LightColorPalette = lightColors(
    primary = primaryColor,
    onPrimary = white,
    background = white,
    onBackground = black,
    surface = white,
    onSurface = black,

)

@Composable
fun ProyectoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {


    val colors = if (darkTheme) {
           DarkColorPalette
        }else { LightColorPalette }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}