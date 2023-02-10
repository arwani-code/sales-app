package com.arwani.ahmad.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.arwani.ahmad.ui.components.TopBar
import com.arwani.ahmad.ui.navigation.Screen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val products by homeViewModel.getProducts().observeAsState()
    if (products?.isEmpty() == true) homeViewModel.insertAllProducts()

    Scaffold(topBar = {
        TopBar(canNavigate = false, title = "Home")
    }) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { navController.navigate(Screen.Info.route) }) {
                Text(text = "Product Customer")
            }
            Spacer(modifier = modifier.height(16.dp))
            Button(onClick = {
                navController.navigate(Screen.Login.route)
            }) {
                Text(text = "Check Out")
            }

        }
    }
}

