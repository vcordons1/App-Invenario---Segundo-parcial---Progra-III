package com.v1k70r.controlinventario

import com.v1k70r.controlinventario.data.InMemoryInventoryRepository

object DependencyProvider {
    val repository = InMemoryInventoryRepository()
}