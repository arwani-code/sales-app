package com.arwani.ahmad.data

import com.arwani.ahmad.data.local.ProductDao
import com.arwani.ahmad.data.local.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SalesRepository @Inject constructor(private val productDao: ProductDao) {

    fun getAllProducts(): Flow<List<ProductEntity>> = productDao.getAllProduct()

    suspend fun insertProduct(productEntity: ProductEntity) =
        productDao.insertProduct(productEntity)

    suspend fun insertAllProducts(productEntity: List<ProductEntity>) =
        productDao.insertAllProduct(productEntity)

    suspend fun updateQty(id: Int, qty: String) = productDao.updateQty(id, qty)
}