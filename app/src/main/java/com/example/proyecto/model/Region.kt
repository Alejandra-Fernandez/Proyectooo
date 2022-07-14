package com.example.proyecto.model

import com.example.proyecto.R

class Region (
    val id: Int=0,
    val name:String="",
    val description: String="",
    val cant: String="",
    val image:Int=0,
    val products : List<Producto> =listOf()

){
    fun getRegiones() =listOf(
            Region(
                0,
                "Costa Peruana",
                "Lugares mas visitados de la Costa Peruana",
                "5",
                R.drawable.costa2,


                    listOf(
                        Producto(
                            0,
                            "Huacachina",
                            5,
                            R.drawable.huacachina,
                        ),
                        Producto(
                            1,
                            "Paracas",
                            5,
                            R.drawable.paracas,
                        ),
                        Producto(
                            2,
                            "Punta Sal",
                            6,
                            R.drawable.puntasal,
                        ),
                        Producto(
                            3,
                            "Huanchaco",
                            6,
                            R.drawable.huanchaco,
                        ),
                        Producto(
                            4,
                            "Caral",
                            7,
                            R.drawable.caral,
                        )

                    )



            ),
            Region(
                1,
                "Sierra Peruana",
                "Lugares mas visitados de la Sierra Peruana",
                "5",
                R.drawable.sierra2,
                listOf(
                    Producto(
                        0,
                        "Macchu Picchu",
                        8,
                        R.drawable.machupichu,
                    ),
                    Producto(
                        1,
                        "Montaña de 7 colores",
                        7,
                        R.drawable.sietecolores,
                    ),
                    Producto(
                        2,
                        "Lago Titi-Caca",
                        5,
                        R.drawable.lagotiticaca,
                    ),
                    Producto(
                        3,
                        "Iglesias de Ayacucho",
                        6,
                        R.drawable.ayacucho,
                    ),
                    Producto(
                        4,
                        "Ciudad de Huancayo",
                        5,
                        R.drawable.huancayo,
                    )

                )
            ),
            Region(
                2,
                "Selva Peruana",
                "Lugares mas visitados de la Selva Peruana",
                "5",
                R.drawable.selva2,
                listOf(
                    Producto(
                        0,
                        "Reserva Nacional Tambopata",
                        7,
                        R.drawable.tambopata,
                    ),
                    Producto(
                        1,
                        "Reserva Nacional Pacaya Samiria",
                        6,
                        R.drawable.pacaya,
                    ),
                    Producto(
                        2,
                        "Laguna Azul, Tarapoto",
                        6,
                        R.drawable.tarapoto,
                    ),
                    Producto(
                        3,
                        "Parque Nacional del Manu",
                        5,
                        R.drawable.manu,
                    ),
                    Producto(
                        4,
                        "Kuélap, Amazonas",
                        5,
                        R.drawable.kuelap,
                    )

                )

        ))

}