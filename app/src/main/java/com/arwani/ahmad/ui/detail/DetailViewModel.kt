package com.arwani.ahmad.ui.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.data.SalesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: SalesRepository) : ViewModel() {
    var inputUser by mutableStateOf("")

    fun setInput(input: String) {
        inputUser = input
    }

    fun updateQtyOpname(id: Int, qty: String){
        viewModelScope.launch { repository.updateQty(id, qty) }
    }
}