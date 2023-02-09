package com.arwani.ahmad.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arwani.ahmad.ui.navigation.Screen
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arwani.ahmad.data.local.ProductEntity
import com.arwani.ahmad.ui.add.AddScreen
import com.arwani.ahmad.ui.components.BottomBar
import com.arwani.ahmad.ui.detail.DetailScreen
import com.arwani.ahmad.ui.home.HomeScreen
import com.arwani.ahmad.ui.info.InfoScreen
import com.arwani.ahmad.ui.login.LoginScreen
import com.arwani.ahmad.ui.status.StatusScreen

@Composable
fun JetSalesApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            if (currentRoute == Screen.Home.route || currentRoute == Screen.Status.route) {
                BottomBar(navController = navController)
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = modifier.padding(it)
        ) {
            composable(route = Screen.Login.route) {
                LoginScreen(navController = navController)
            }
            composable(route = Screen.Home.route) {
                HomeScreen(navController = navController)
            }
            composable(route = Screen.Status.route) {
                StatusScreen()
            }
            composable(route = Screen.Info.route) {
                InfoScreen(navController = navController)
            }
            composable(route = Screen.Detail.route) {
                val product =
                    navController.previousBackStackEntry?.savedStateHandle?.get<ProductEntity>("product")
                product?.let { it1 -> DetailScreen(productEntity = it1) }
            }
            composable(route = Screen.Add.route) {
                AddScreen()
            }
        }
    }
}