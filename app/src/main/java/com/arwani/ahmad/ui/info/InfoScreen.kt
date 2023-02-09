package com.arwani.ahmad.ui.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.arwani.ahmad.ui.components.TopBar
import com.arwani.ahmad.R

@Composable
fun InfoScreen(modifier: Modifier = Modifier) {
    Scaffold(topBar = {
        TopBar(canNavigate = false, title = "Info")
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
        }
    }
}