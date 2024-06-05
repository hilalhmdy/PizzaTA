package com.example.pizzata.model

import com.example.pizzata.R

data class Menu(
    val id : Long,
    val image : Int,
    val title : String,
    val describe : String,
    val price: String,
)

val dummyMenu = listOf(
    Menu(
        1,
        R.drawable.menu1,
        "Yummy Creammy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        2,
        R.drawable.menu1,
        "Yummy Creammy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        3,
        R.drawable.menu1,
        "Yummy Creammy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        1,
        R.drawable.menu1,
        "Yummy Creammy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        2,
        R.drawable.pizza,
        "Yummy Creammy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        3,
        R.drawable.menu1,
        "Yummy Creammy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
)
