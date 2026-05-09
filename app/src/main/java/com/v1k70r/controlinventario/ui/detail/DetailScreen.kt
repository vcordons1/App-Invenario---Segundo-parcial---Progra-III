package com.v1k70r.controlinventario.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.v1k70r.controlinventario.ui.components.InventoryInfoRow
import com.v1k70r.controlinventario.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(productId: String, viewModel: DetailViewModel, onBack: () -> Unit) {
    val product = viewModel.getProduct(productId) ?: return

    Scaffold(
        containerColor = DarkBG,
        topBar = {
            TopAppBar(
                title = { Text("Detalle", color = TextWhite) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkSurface),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = TextWhite)
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize()) {
            InventoryInfoRow("Categoría", product.category)
            InventoryInfoRow("Precio venta", "Q${product.salePrice}")
            InventoryInfoRow("Stock actual", "${product.currentStock} uds")

            Spacer(modifier = Modifier.weight(1f))

            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = { viewModel.adjustStock(productId, 1) }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = PrimaryRed)) {
                    Text("Agregar")
                }
                Button(onClick = { viewModel.adjustStock(productId, -1) }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = DarkSurface)) {
                    Text("Retirar", color = PrimaryRed)
                }
            }
        }
    }
}