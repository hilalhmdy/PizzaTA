package com.example.pizzata.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryTextColor,
    secondary = SecondaryColor
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryTextColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryTextColor,
    background = PrimaryBackgroundColor,
    error = ErrorColor
)


@Composable
fun PizzaTATheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}