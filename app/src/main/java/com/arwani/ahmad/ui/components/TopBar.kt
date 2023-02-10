package com.arwani.ahmad.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    modifier: Modifier = Modifier,
    canNavigate: Boolean,
    navigateUp: () -> Unit = {},
    title: String
){
    Column {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.primary)
                .padding(horizontal = 10.dp, vertical = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
                if (canNavigate) {
                    IconButton(onClick = { navigateUp() }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                }
                Text(
                    modifier = modifier.padding(horizontal = 8.dp),
                    text = title,
                    style = MaterialTheme.typography.h6,
                    color = Color.White
                )
            }
        }
        Divider()
    }
}