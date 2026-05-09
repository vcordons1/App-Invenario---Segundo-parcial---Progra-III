package com.v1k70r.controlinventario.domain

data class Product(
    val id: String,
    val name: String,
    val sku: String,
    val category: String,
    val salePrice: Double,
    val costPrice: Double,
    val currentStock: Int,
    val minStock: Int
)