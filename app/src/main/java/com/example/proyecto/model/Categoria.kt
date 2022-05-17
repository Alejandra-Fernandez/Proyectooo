package com.example.proyecto.model

import com.example.proyecto.R

class Categoria (
    val id: Int=0,
    val category:String="",
    val image:Int=0,

    ){
        fun getCategories()= listOf(
            Categoria(
                0,
                "Lima",
                R.drawable.lima,
            ),
            Categoria(
                1,
                "Cusco",
                R.drawable.cusco,
            ),
            Categoria(
                2,
                "Puno",
                R.drawable.puno,
            ),
            Categoria(
                3,
                "Ica",
                R.drawable.ica,
            ),
            Categoria(
                4,
                "Arequipa",
                R.drawable.arequipa,
            ),
            Categoria(
                5,
                "Piura",
                R.drawable.piura,
            ),
            Categoria(
                6,
                "Loreto",
                R.drawable.loreto,
            )
    )

}
