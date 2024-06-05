package com.example.pizzata.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.pizzata.R

data class Category(
    @DrawableRes val imageCategory: Int,
    @StringRes val textCategory: Int
)

val dummyCategory = listOf(
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
    R.drawable.pizza to R.string.category,
).map { Category(it.first, it.second) }