package com.arwani.ahmad.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.arwani.ahmad.ui.navigation.Screen
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.arwani.ahmad.ui.home.HomeScreen
import com.arwani.ahmad.ui.info.InfoScreen
import com.arwani.ahmad.ui.login.LoginScreen
import com.arwani.ahmad.ui.status.StatusScreen

@Composable
fun JetSalesApp(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
    Scaffold(
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Login.route,
            modifier = modifier.padding(it)
        ) {
            composable(route = Screen.Login.route){
                LoginScreen(navController = navController)
            }
            composable(route = Screen.Home.route){
                HomeScreen()
            }
            composable(route = Screen.Status.route){
                StatusScreen()
            }
            composable(route = Screen.Info.route){
                InfoScreen()
            }
        }
    }
}