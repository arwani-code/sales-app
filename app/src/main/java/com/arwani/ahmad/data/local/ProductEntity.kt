package com.arwani.ahmad.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "id")
    val id: Int = 0,

    @field:ColumnInfo(name = "customer_id")
    val customerId: String,

    @field:ColumnInfo(name = "customer_name")
    val customerName: String,

    @field:ColumnInfo(name = "part_no")
    val partNo: String,

    @field:ColumnInfo(name = "part_desc")
    val partDesc: String,

    @field:ColumnInfo(name = "lot_batch_no")
    val batchNo: Int,

    @field:ColumnInfo(name = "expiration_date")
    val expirationDate: String,

    @field:ColumnInfo(name = "qty_opname")
    val qtyOpname: String,


    )
