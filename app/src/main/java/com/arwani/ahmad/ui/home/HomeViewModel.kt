package com.arwani.ahmad.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.arwani.ahmad.data.SalesRepository
import com.arwani.ahmad.data.local.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: SalesRepository) : ViewModel() {

    fun getProducts(): LiveData<List<ProductEntity>> = repository.getAllProducts().asLiveData()

     fun insertAllProducts() {
         viewModelScope.launch {
             repository.insertAllProducts(products)
         }
    }
}

val products = listOf(
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 200226,
        partNo = "X66F6JR3",
        partDesc = "HEARTRAIL II JUDKIN RIGHT 3.5, 6FR",
        expirationDate = "31/01/2023",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 200909,
        partNo = "X667S418",
        partDesc = "RUNTHROUGH NS-PTCA W. INTERMEDIATE",
        expirationDate = "31/08/2023",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 210331,
        partNo = "X66DS41H",
        partDesc = "RUNTHROUGH NS-PTCA WIRE HYPERCOAT",
        expirationDate = "28/02/2024",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 200226,
        partNo = "X66F863A",
        partDesc = "FINECROSS 1,8FR,130 CM ",
        expirationDate = "31/08/2023",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 211116,
        partNo = "X66F7A01",
        partDesc = "HEARTRAIL II AMPLATZ L 1.0, 7 FR",
        expirationDate = "31/10/2024",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 211224,
        partNo = "X66F6JR3",
        partDesc = "HEARTRAIL II JUDKIN RIGHT 3.5, 6FR",
        expirationDate = "30/11/2024",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 200701670,
        partNo = "X66G1652",
        partDesc = "ELIMINATE ASPIRATION CATHETER 7 FR",
        expirationDate = "31/07/2023",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 210908,
        partNo = "X66DS41H",
        partDesc = "RUNTHROUGH NS-PTCA WIRE HYPERCOAT",
        expirationDate = "30/08/2024",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 210420,
        partNo = "X66F6JR3",
        partDesc = "RUNTHROUGH NS-PTCA W. INTERMEDIATE",
        expirationDate = "31/03/2024",
        qtyOpname = ""
    ),
    ProductEntity(
        customerId = "X74440",
        customerName = "Rs Medistra",
        batchNo = 211223,
        partNo = "X66AS141",
        partDesc = "RUNTHROUGH NS-PTCA WIRE FLOPPY ",
        expirationDate = "31/11/2024",
        qtyOpname = ""
    )
)