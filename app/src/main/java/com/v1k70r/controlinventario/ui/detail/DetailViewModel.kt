package com.v1k70r.controlinventario.ui.detail

import androidx.lifecycle.ViewModel
import com.v1k70r.controlinventario.data.InventoryRepository
import com.v1k70r.controlinventario.domain.Product

class DetailViewModel(private val repository: InventoryRepository) : ViewModel() {
    fun getProduct(id: String): Product? = repository.getProductById(id)

    fun adjustStock(id: String, amount: Int) {
        repository.updateStock(id, amount)
    }
}