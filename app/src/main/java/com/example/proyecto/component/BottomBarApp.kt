package com.example.proyecto.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import com.example.proyecto.R
import com.example.proyecto.screen.Section


@Composable
fun BottomBarApp(
    items:List<Section>,
    currentSection: Section,
    onSectionSelected: (Section)->Unit,
){
    BottomNavigation (
        modifier=Modifier.height(50.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.surface
    ){
        items.forEach { section ->
            val selected = section == currentSection
            BottomNavigationItem(
                selected = selected,
                onClick = { onSectionSelected(section) },
                icon = {Icon(
                    painter = painterResource(id = section.icon),
                    contentDescription = "",
                    modifier = Modifier.size(24.dp))},
                selectedContentColor = MaterialTheme.colors.primary,
                unselectedContentColor = MaterialTheme.colors.onBackground,

                )
        }
    }

}