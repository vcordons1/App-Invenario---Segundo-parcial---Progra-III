package com.v1k70r.controlinventario.ui.add

import androidx.lifecycle.ViewModel
import com.v1k70r.controlinventario.data.InventoryRepository

class AddProductViewModel(private val repository: InventoryRepository) : ViewModel() {
    fun saveProduct(name: String, sku: String, category: String, sale: String, cost: String, stock: String, min: String) {
        repository.addProduct(
            name, sku, category,
            sale.toDoubleOrNull() ?: 0.0,
            cost.toDoubleOrNull() ?: 0.0,
            stock.toIntOrNull() ?: 0,
            min.toIntOrNull() ?: 0
        )
    }
}