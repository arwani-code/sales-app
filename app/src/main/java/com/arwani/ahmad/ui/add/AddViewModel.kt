package com.arwani.ahmad.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.data.SalesRepository
import com.arwani.ahmad.data.local.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val repository: SalesRepository) : ViewModel() {
    var partNo by mutableStateOf("")
    var desc by mutableStateOf("")
    var batchNo by mutableStateOf("")
    var qtyName by mutableStateOf("")

    fun addProduct(date: String) {
        viewModelScope.launch {
            repository.insertProduct(
                ProductEntity(
                    partNo = partNo,
                    partDesc = desc,
                    batchNo = batchNo.toInt(),
                    qtyOpname = qtyName,
                    expirationDate = date
                )
            )
        }
    }
}