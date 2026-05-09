package com.v1k70r.controlinventario.ui.inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.v1k70r.controlinventario.ui.components.ProductCard
import com.v1k70r.controlinventario.ui.theme.*

@Composable
fun InventoryScreen(viewModel: InventoryViewModel, onProductClick: (String) -> Unit, onAddClick: () -> Unit) {
    val products by viewModel.products.collectAsState()

    Scaffold(
        containerColor = DarkBG,
        topBar = {
            Column(modifier = Modifier.background(DarkSurface).padding(16.dp)) {
                Text("Inventario", color = TextWhite, style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    placeholder = { Text("Buscar producto...", color = TextGray) },
                    modifier = Modifier.fillMaxWidth().background(DarkSurface),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedTextColor = TextWhite,
                        unfocusedTextColor = TextWhite,
                        focusedBorderColor = PrimaryRed,
                        unfocusedBorderColor = TextGray
                    )
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick, containerColor = PrimaryRed, contentColor = TextWhite) {
                Text("+")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text("TODOS LOS PRODUCTOS", modifier = Modifier.padding(16.dp), color = TextGray)
            LazyColumn {
                items(products) { product ->
                    ProductCard(product, onClick = { onProductClick(product.id) })
                }
            }
        }
    }
}