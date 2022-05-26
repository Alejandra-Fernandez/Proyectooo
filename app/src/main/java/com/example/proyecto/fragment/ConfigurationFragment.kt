import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavController

@Composable
private fun ConfigurationFragment(navController: NavController){
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(){
        Text(text = "Nombre:")
        TextField(
            value = text,
            onValueChange = {newText ->
                text = newText},
            modifier = Modifier.fillMaxWidth()
        )

        Button(onClick = { navController.navigate("detail/1")}) {
            Text(text = "Configurar")
        }
    }
}