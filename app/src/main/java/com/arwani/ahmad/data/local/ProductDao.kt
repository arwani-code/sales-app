package com.arwani.ahmad.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getAllProduct(): Flow<List<ProductEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllProduct(product: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: ProductEntity)

    @Query("UPDATE products SET qty_opname = :qty WHERE id = :id")
    suspend fun updateQty(id: Int, qty: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLocation(currentEntity: CurrentEntity)

    @Query("SELECT * FROM current")
    fun getLocations(): Flow<List<CurrentEntity>>
}