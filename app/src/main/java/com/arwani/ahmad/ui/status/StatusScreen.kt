package com.arwani.ahmad.ui.status

import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.arwani.ahmad.data.local.CurrentEntity
import com.arwani.ahmad.ui.components.TopBar

@Composable
fun StatusScreen(statusViewModel: StatusViewModel = hiltViewModel()) {
    val status by statusViewModel.getLocations.collectAsState(initial = emptyList())
    Scaffold(topBar = {
        TopBar(canNavigate = false, title = "Status")
    }) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(inner),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            if (status.isNotEmpty()) {
                StatusItem(status = status[0])
            }
        }
    }
}

@Composable
fun StatusItem(status: CurrentEntity) {
    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = 10.dp,
        contentColor = Color.Blue,
        modifier = paddingModifier
    ) {
        Column() {
            Text(
                text = "Check In",
                modifier = paddingModifier
            )
            Text(
                text = status.locationName,
                color = Color.Black,
                modifier = paddingModifier
            )
            Text(
                text = status.date, color = Color.Black,
                modifier = paddingModifier
            )
        }
    }
}