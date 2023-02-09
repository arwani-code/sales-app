package com.arwani.ahmad.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.arwani.ahmad.R
import com.arwani.ahmad.ui.navigation.NavigationItem
import com.arwani.ahmad.ui.navigation.Screen


@Composable
fun BottomBar(
    navController: NavHostController,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navigationItems = listOf(
        NavigationItem(title = "Home", icon = Icons.Default.Home, screen = Screen.Home),
        NavigationItem(
            title = "Status", icon = Icons.Default.CheckCircle, screen = Screen.Status
        )
    )
    BottomNavigation(
    ) {
        navigationItems.map { item ->
            BottomNavigationItem(selected = currentRoute == item.screen.route, onClick = {
                navController.navigate(item.screen.route) {
                    popUpTo(navController.graph.findStartDestination().id) {
                        saveState = true
                    }
                    restoreState = true
                    launchSingleTop = true
                }
            }, label = { Text(item.title) },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.title)
                })
        }

    }

}