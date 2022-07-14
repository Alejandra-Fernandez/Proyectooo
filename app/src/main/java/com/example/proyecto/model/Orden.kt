package com.example.proyecto.model

import com.example.proyecto.R

class Orden (
    val id: Int=0,
    val title: String="",
    val descrip: String="",
    val count: Int=0,
    val image:Int=0,

){
   fun getOrders()= listOf(
            Orden(
                0,
                "Costa Peruana",
                "Lugares mas visitados de la Costa Peruana",
                10,
                R.drawable.costa2,
            ),
            Orden(
                0,
                "Sierra Peruana",
                "Lugares mas visitados de la Costa Peruana",
                10,
                R.drawable.sierra2,
            ),
            Orden(
                0,
                "Selva Peruana",
                "Lugares mas visitados de la Costa Peruana",
                10,
                R.drawable.selva2,
            )
    )

}