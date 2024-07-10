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
        "Yummy Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        2,
        R.drawable.menu1,
        "Garlic Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        3,
        R.drawable.menu1,
        "Cheesy Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        4,
        R.drawable.menu1,
        "Cow Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        5,
        R.drawable.menu1,
        "Cat Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        6,
        R.drawable.menu1,
        "Pasta Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        7,
        R.drawable.menu1,
        "Sos Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
    Menu(
        8,
        R.drawable.menu1,
        "Onion Creamy Pizza",
        "Pizza dengan campuran keju dan daging",
        "172.000"
    ),
)
