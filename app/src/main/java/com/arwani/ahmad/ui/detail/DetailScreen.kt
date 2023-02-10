package com.arwani.ahmad.ui.detail

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.arwani.ahmad.MainCamera
import com.arwani.ahmad.data.local.ProductEntity
import com.arwani.ahmad.ui.components.TopBar

@Composable
fun DetailScreen(productEntity: ProductEntity, navHostController: NavHostController ,detailViewModel: DetailViewModel = hiltViewModel()) {

    val context = LocalContext.current

    Scaffold(topBar = {
        TopBar(canNavigate = false, title = "Detail")
    }) { inner ->
        LazyColumn(modifier = Modifier.padding(inner), contentPadding = PaddingValues(16.dp)) {
            item {
                NameSection(title = "Customer Id", value = productEntity.customerId)
                NameSection(title = "Customer Name", value = productEntity.customerName)
                NameSection(title = "Part No", value = productEntity.partNo)
                NameSection(title = "Part Desc", value = productEntity.partDesc)
                NameSection(title = "Lot Batch No", value = productEntity.batchNo.toString())
                NameSection(title = "Expired Date", value = productEntity.expirationDate)
                TextField(
                    value = detailViewModel.inputUser,
                    onValueChange = { detailViewModel.setInput(it) },
                    label = {
                        Text(text = "Qty Opname")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                )
                Button(onClick = {
                    if (detailViewModel.inputUser.isNotEmpty()) {
                        detailViewModel.updateQtyOpname(productEntity.id, detailViewModel.inputUser)
                        context.startActivity(Intent(context, MainCamera::class.java))
                    }
                }) {
                    Text(text = "Submit")
                }
            }
        }
    }
}

@Composable
fun NameSection(modifier: Modifier = Modifier, title: String, value: String) {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(text = "$title : ")
            }
            withStyle(
                style = SpanStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            ) {
                append(text = " $value ")
            }
        }
    )
    Divider(
        modifier = modifier.padding(top = 10.dp, end = 50.dp, bottom = 12.dp),
        startIndent = 50.dp
    )
}
