package com.arwani.ahmad.ui.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arwani.ahmad.ui.components.TopBar
import com.arwani.ahmad.R
import com.arwani.ahmad.data.local.ProductEntity
import com.arwani.ahmad.ui.navigation.Screen

@Composable
fun InfoScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    infoViewModel: InfoViewModel = hiltViewModel()
) {
    val products by infoViewModel.products.collectAsState(initial = emptyList())
    Scaffold(topBar = {
        TopBar(canNavigate = false, title = "Info")
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = { navController.navigate(Screen.Add.route) },
            modifier = modifier.navigationBarsPadding()
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "add",
                tint = MaterialTheme.colors.onPrimary
            )
        }
    }) { innerPadding ->
        LazyColumn(modifier = modifier.padding(innerPadding)) {
            item {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(230.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.farmasi),
                        contentDescription = "",
                        modifier = modifier.fillMaxSize()
                    )
                }
            }
            item {
                Column(modifier = modifier.padding(horizontal = 12.dp)) {
                    Text(
                        text = "Rs Medistra",
                        style = MaterialTheme.typography.h4,
                        modifier = modifier.padding(vertical = 12.dp)
                    )
                    Text(text = "Salah satu toko obat di kawasan Jakarta ini membuat deskripsi toko yang berisi informasi obat, serta batas maksimal order agar produk bisa dikirim pada hari yang sama.")
                    Text(
                        text = "Daftar Product",
                        style = MaterialTheme.typography.h5,
                        modifier = modifier.padding(vertical = 12.dp)
                    )
                }
            }
            items(products, key = { it.id }) {
                ProductItem(product = it, navController = navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductItem(
    modifier: Modifier = Modifier,
    product: ProductEntity,
    navController: NavHostController
) {
    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .height(90.dp)
            .background(Color.White.copy(0.7f)),
        elevation = 4.dp,
        shape = CircleShape.copy(CornerSize(10.dp)),
        onClick = {
            navController.currentBackStackEntry?.savedStateHandle?.set(
                key = "posts",
                value = product
            )
            navController.navigate(Screen.Detail.route)
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = product.partNo,
                maxLines = 1,
                style = MaterialTheme.typography.subtitle2,
                color = Color.Black.copy(0.9f)
            )
            Divider(color = Color.Black)
            Text(
                text = product.partDesc,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color.Black.copy(0.4f)
            )
        }
    }
}