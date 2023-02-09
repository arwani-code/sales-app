package com.arwani.ahmad.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Info : Screen("home/{id}") {
        fun createRoute(id: Int) = "home/$id"
    }
    object Status : Screen("status")
    object Login : Screen("login")
}