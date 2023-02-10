package com.arwani.ahmad.ui.status

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.data.SalesRepository
import com.arwani.ahmad.data.local.CurrentEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StatusViewModel @Inject constructor(private val repository: SalesRepository) : ViewModel() {

    val getLocations = repository.getLocation()

    fun insertLocation(currentEntity: CurrentEntity) {
        viewModelScope.launch {
            repository.insertLocation(currentEntity)
        }
    }
}