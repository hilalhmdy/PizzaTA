package com.example.pizzata.model

import com.example.pizzata.R

data class ActivityNews (
    val id : Int,
    val image: Int,
)

val dummyActivity = listOf(
    ActivityNews( 1, R.drawable.pizza_banner, ),
    ActivityNews( 1, R.drawable.pizza_banner, ),
)