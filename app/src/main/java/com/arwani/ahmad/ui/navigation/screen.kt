package com.arwani.ahmad.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Info : Screen("info")
    object Status : Screen("status")
    object Login : Screen("login")
    object Detail : Screen("detail")
    object Add : Screen("add")
}