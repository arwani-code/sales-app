package com.arwani.ahmad.ui.detail

import androidx.lifecycle.ViewModel
import com.arwani.ahmad.data.SalesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val repository: SalesRepository) : ViewModel() {
}