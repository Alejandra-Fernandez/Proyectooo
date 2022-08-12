package com.example.proyecto.fragment

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import com.example.proyecto.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.work.*
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import com.example.proyecto.Room.feature_lugares.domain.model.Lugares
import com.example.proyecto.Room.feature_lugares.presentation.HomeEvent
import com.example.proyecto.Room.feature_lugares.presentation.LugaresViewModel
import com.example.proyecto.Room.feature_lugares.presentation.components.LugaresItem
import com.example.proyecto.WorkManager.ColorFilterWorker
import com.example.proyecto.WorkManager.DownloadWorker
import com.example.proyecto.WorkManager.WorkerKeys
import com.example.proyecto.component.card.TagCard
import com.example.proyecto.model.Categoria
import com.example.proyecto.navigation.Screen
import java.util.*
import java.util.concurrent.TimeUnit


@SuppressLint("EnqueueWork", "InvalidPeriodicWorkRequestInterval")
@Composable
fun OrderCardFragment(
    navController: NavController,

) {
    val viewModel: LugaresViewModel = hiltViewModel()
    val state = viewModel.state.value
    //OneTimeWork
    val downloadRequest = OneTimeWorkRequestBuilder<DownloadWorker>()
        .setConstraints(
            Constraints.Builder()
                .setRequiredNetworkType(
                    NetworkType.CONNECTED
                )
                .build()
        )
        .build()

    //Pasando parametros, color "#ffee58"
    val data = Data.Builder()
    data.putString("color","#ffee58")

    val colorFilterRequest = OneTimeWorkRequestBuilder<ColorFilterWorker>().setInputData(data.build())
        .build()

    //PERIODIC WORK MANAGER
    val downloadRequest3 = PeriodicWorkRequestBuilder<DownloadWorker>(15,TimeUnit.MINUTES).build()



    val downloadRequest2 = PeriodicWorkRequest.Builder(
        DownloadWorker::class.java,1,TimeUnit.MINUTES).build()
    val downloadRequest4 = OneTimeWorkRequestBuilder<DownloadWorker>()
        .setConstraints(
            Constraints.Builder()
                .setRequiredNetworkType(
                    NetworkType.CONNECTED
                )
                .build()
        )
        .build()
    //val colorFilterRequest = PeriodicWorkRequestBuilder<ColorFilterWorker>().build()
    val context = LocalContext.current
    val workManager = WorkManager.getInstance(context.applicationContext)
    //Log.e("TEST1",context.toString())
    //Log.e("TEST2",context.applicationContext.toString())

    Scaffold(

        floatingActionButton = {
            HomeFab(
                onFabClicked = {

                }
            )

        }
    ) { innerPadding ->


        val workInfos = workManager
            .getWorkInfosForUniqueWorkLiveData("download")
            .observeAsState()
            .value
        val downloadInfo = remember(key1 = workInfos) {
            workInfos?.find { it.id == downloadRequest.id }
        }
        val filterInfo = remember(key1 = workInfos) {
            workInfos?.find { it.id == colorFilterRequest.id }
        }
        val downloadInfo2 = remember(key1 = workInfos) {
            workInfos?.find { it.id == downloadRequest2.id }
        }
        val imageUri by derivedStateOf {
            val downloadUri = downloadInfo?.outputData?.getString(WorkerKeys.IMAGE_URI)
                ?.toUri()
            val filterUri = filterInfo?.outputData?.getString(WorkerKeys.FILTER_URI)
                ?.toUri()
            filterUri ?: downloadUri
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,

            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            imageUri?.let { uri ->
                Image(
                    painter = rememberImagePainter(
                        data = uri
                    ),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
            Button(
                onClick = {
                    //WorkManager forma secuencial con Then
                    workManager
                        .beginUniqueWork(
                            "download",
                            ExistingWorkPolicy.KEEP,
                            downloadRequest
                        )
                        .then(colorFilterRequest)
                        .enqueue()

                },
                enabled = downloadInfo?.state != WorkInfo.State.RUNNING
            ) {
                Text(text = "Presiona aqui")
            }
            if (downloadInfo?.state == WorkInfo.State.RUNNING){
                Log.e("test","test")
            }
            Log.e("abc",downloadInfo?.state.toString())
            Spacer(modifier = Modifier.height(8.dp))

            when (downloadInfo?.state) {

                WorkInfo.State.RUNNING -> Log.e("test", "test")
                WorkInfo.State.SUCCEEDED -> Text("Descara exitosa")
                WorkInfo.State.FAILED -> Text("Error en la descarga...")
                WorkInfo.State.CANCELLED -> Text("Descarga cancelada...")
                WorkInfo.State.ENQUEUED -> Text("Descarga en cola")
                WorkInfo.State.BLOCKED -> Text("Descarga bloqueada")


            }
            Spacer(modifier = Modifier.height(8.dp))
            when (filterInfo?.state) {
                WorkInfo.State.RUNNING -> Text("Aplicando filtro...")
                WorkInfo.State.SUCCEEDED -> Text("Filtro exitoso")
                WorkInfo.State.FAILED -> Text("Error en el filtro...")
                WorkInfo.State.CANCELLED -> Text("Filtro cancelado...")
                WorkInfo.State.ENQUEUED -> Text("Filtro en cola")
                WorkInfo.State.BLOCKED -> Text("Filtro bloqueado")


            }
            Button(onClick = {
                //PeriodicWork
                workManager.enqueue(downloadRequest3)

            }) {
                Text(text = "Descargar Album")
            }
            Button(onClick = {
                //WorkManager paralelo
                workManager
                    .beginWith(Arrays.asList(downloadRequest,downloadRequest4)).enqueue()

            }) {
                Text(text = "Descargar Varios")
            }
        }
        Column() {

        }
        LazyColumn {
            item {
                //Categories2()

            }
            item {
                //Categories2()
            }

            item {

                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )
                        ) {
                            append("¿Estas buscando mas lugares? \n")
                        }

                    },
                    textAlign = TextAlign.Center
                )

            }

        }
        HomeContent(

            modifier = Modifier.padding(innerPadding),
            onDeleteLugares = { viewModel.onEvent(HomeEvent.DeleteLugares(it)) },
            onEditLugares = {
                navController.navigate(
                    route = Screen.Edit.passId(it)
                )
            },
            lugar = state.lugar
        )
    }
}


@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    onDeleteLugares: (lugares: Lugares) -> Unit,
    onEditLugares: (id: Int?) -> Unit,
    lugar: List<Lugares> = emptyList()
) {
    Surface(
        color = MaterialTheme.colors.surface,
        modifier = modifier
    ) {
        LazyColumn {

            items(lugar) { lugares ->
                LugaresItem(

                    lugares = lugares,
                    onEditLugares = { onEditLugares(lugares.id) },
                    onDeleteLugares = { onDeleteLugares(lugares) }
                )
            }
        }
    }
}

@Composable
fun HomeFab(
    modifier: Modifier = Modifier,
    onFabClicked: () -> Unit = {  }
) {
    FloatingActionButton(
        onClick = onFabClicked,
        modifier = modifier
            .height(52.dp)
            .widthIn(min = 52.dp),
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Icon(imageVector = Icons.Outlined.Add, contentDescription = stringResource(id = R.string.add_user))
    }
}
/*
@Preview(showBackground = true)
@Composable
fun PreviewLugaresContent() {

    ProyectoTheme(darkTheme = false) {
        HomeContent(onDeleteLugares = {}, onEditLugares = {})
    }
}*/
/*
@Preview(showBackground = true)
@Composable
fun PreviewLugaresFab() {
    ProyectoTheme(darkTheme = false) {
        HomeFab()
    }
}*/





/*
    val orders = Orden().getOrders()
    LazyColumn(Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceBetween){
        items(orders){
            FavoritosCard(it.title,
                "Ciudad de ${it.count}",
                it.image,
                Icons.Default.Close,
                 onItemClick =  {
            }
            )


        }

    }*/

@Preview
@Composable
fun Categories2(){
    val categories = Categoria().getCategories()
    Column{
        Text(text = buildAnnotatedString {
            withStyle(
                style= SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp

                )
            ){
                append("¿Estas buscando mas lugares? \n")
            }
            withStyle(
                style= SpanStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 21.sp
                )
            ){
                append("Selecciona una ciudad")
            }
        },
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.padding(10.dp))
        LazyRow {
            items(categories){
                TagCard(it.category)
            }

        }
    }
}
