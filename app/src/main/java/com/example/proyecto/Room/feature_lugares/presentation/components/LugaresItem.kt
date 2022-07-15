package com.example.proyecto.Room.feature_lugares.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.ui.theme.ProyectoTheme
import com.example.proyecto.ui.theme.white

@Composable
fun LugaresItem(
    modifier: Modifier = Modifier,
    lugares: Lugares,
    onEditLugares: () -> Unit,
    onDeleteLugares: () -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 14.dp, vertical = 12.dp),
        elevation = 3.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "${lugares.departamento} / ${lugares.capital}",
                    style = MaterialTheme.typography.h6
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = lugares.superficie.toString() + " km2",
                    style = MaterialTheme.typography.caption.copy(color = white)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = lugares.habitantes.toString() ,
                    style = MaterialTheme.typography.caption.copy(color = white)
                )
            }
            Row {
                IconButton(onClick = onEditLugares) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
                IconButton(onClick = onDeleteLugares) {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLugaresItem() {
    ProyectoTheme {
        LugaresItem(
            lugares = Lugares(departamento = "Amazonas", capital = "Chachapoyas", superficie = 39249, habitantes = 379384),
            onEditLugares = {},
            onDeleteLugares = {}
        )
    }
}