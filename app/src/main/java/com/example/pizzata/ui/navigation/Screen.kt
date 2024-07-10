package com.example.pizzata.ui.navigation

sealed class Screen(val route: String) {
    object Home     : Screen("home")
    object Order    : Screen("order")
    object ScanPage : Screen("scan")
    object Inbox    : Screen("inbox")
    object Profile  : Screen("profile")
    object Menu  : Screen("menu")
    object Login    : Screen("login")
    object Register : Screen("register")
    object DetailMenu : Screen("menu/{id}") {
        fun createRoute(id: Long) = "menu/$id"
    }
}
