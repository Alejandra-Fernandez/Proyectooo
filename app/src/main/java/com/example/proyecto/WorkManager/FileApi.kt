package com.example.proyecto.WorkManager

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

//Recibir fotos desde sitio web
interface FileApi {

    @GET("/200/300")
    suspend fun downloadImage(): Response<ResponseBody>

    //Patron singleton
    companion object{
        val instance by lazy {
            Retrofit.Builder()
                .baseUrl("https://picsum.photos/")
                .build()
                .create(FileApi::class.java)
        }
    }

}