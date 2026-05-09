package com.v1k70r.controlinventario.data

import com.v1k70r.controlinventario.domain.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.util.UUID

interface InventoryRepository {
    fun getProducts(): StateFlow<List<Product>>
    fun addProduct(name: String, sku: String, category: String, salePrice: Double, costPrice: Double, stock: Int, minStock: Int)
    fun updateStock(productId: String, amount: Int)
    fun getProductById(productId: String): Product?
}

class InMemoryInventoryRepository : InventoryRepository {
    private val _products = MutableStateFlow<List<Product>>(emptyList())

    override fun getProducts(): StateFlow<List<Product>> = _products.asStateFlow()

    override fun addProduct(name: String, sku: String, category: String, salePrice: Double, costPrice: Double, stock: Int, minStock: Int) {
        val newProduct = Product(
            id = UUID.randomUUID().toString(),
            name = name,
            sku = sku,
            category = category,
            salePrice = salePrice,
            costPrice = costPrice,
            currentStock = stock,
            minStock = minStock
        )
        _products.value = _products.value + newProduct
    }

    override fun updateStock(productId: String, amount: Int) {
        _products.value = _products.value.map {
            if (it.id == productId) it.copy(currentStock = it.currentStock + amount) else it
        }
    }

    override fun getProductById(productId: String): Product? = _products.value.find { it.id == productId }
}