package com.arwani.ahmad.ui.info

import androidx.lifecycle.ViewModel
import com.arwani.ahmad.data.SalesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(repository: SalesRepository): ViewModel() {
    val products = repository.getAllProducts()
}