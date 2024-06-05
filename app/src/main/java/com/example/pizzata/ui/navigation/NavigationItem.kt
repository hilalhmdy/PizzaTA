package com.example.pizzata.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pizzata.ui.navigation.Screen

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: Screen
)
