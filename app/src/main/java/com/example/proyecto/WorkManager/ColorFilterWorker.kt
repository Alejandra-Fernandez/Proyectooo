package com.example.proyecto.WorkManager

import android.R.color
import android.content.Context
import android.graphics.*
import android.util.Log
import androidx.core.net.toFile
import androidx.core.net.toUri
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileOutputStream
import java.util.*
import kotlin.collections.ArrayList

//Worker cambiar de color a una imagen
class ColorFilterWorker(
    private val context: Context,
    private val workerParams: WorkerParameters
): CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        val imageFile = workerParams.inputData.getString(WorkerKeys.IMAGE_URI)
            ?.toUri()
            ?.toFile()
        delay(2000L)
        return imageFile?.let { file ->
            val bmp = BitmapFactory.decodeFile(file.absolutePath)
            val resultBmp = bmp.copy(bmp.config, true)
            val paint = Paint()
            //Lista de colores
            val colors: ArrayList<String> = ArrayList()
            colors.add("#e84e40") //red
            colors.add("#ec407a") //pink
            colors.add("#ab47bc") //purple
            colors.add("#7e57c2") //deep purple
            colors.add("#5c6bc0") //indigo
            colors.add("#738ffe") //blue
            colors.add("#29b6f6") //light blue
            colors.add("#26c6da") //cyano
            colors.add("#26a69a") //teal
            colors.add("#2baf2b") //green
            colors.add("#9ccc65") //light green
            colors.add("#d4e157") //lime
            colors.add("#ffee58") //yellow
            colors.add("#ffca28") //amber
            val n = Random().nextInt(colors.size)
            val color = colors.get(n)
            Log.e("RColor",color)
            val intcolor = Color.parseColor(color)
            Log.e("Color",intcolor.toString())

            //Recibe parametros
            val colorPath = inputData.getString("color")
            //Si recibe parametros, lo cambia al color que quieres
            if (colorPath != "N"){
                Log.e("SD","ASDF")
                val x = Color.parseColor(colorPath)
                paint.colorFilter = LightingColorFilter(x,1)
            }else{ //Si no recibe a cualquier color
                paint.colorFilter = LightingColorFilter(intcolor,1)
            }

            val canvas = Canvas(resultBmp)
            canvas.drawBitmap(resultBmp,0f,0f, paint)
            withContext(Dispatchers.IO){
                val resultImageFile = File(context.cacheDir, "new-image.jpg")
                val outputStream = FileOutputStream(resultImageFile)
                val successful = resultBmp.compress(
                    Bitmap.CompressFormat.JPEG,
                    90,
                    outputStream
                )
                if (successful){
                    Result.success(
                        workDataOf(
                            WorkerKeys.FILTER_URI to resultImageFile.toUri().toString()
                        )
                    )
                } else Result.failure()
            }

        }?: Result.failure()
    }
}