package com.v1k70r.controlinventario.ui.inventory

import androidx.lifecycle.ViewModel
import com.v1k70r.controlinventario.data.InventoryRepository

class InventoryViewModel(private val repository: InventoryRepository) : ViewModel() {
    val products = repository.getProducts()
}