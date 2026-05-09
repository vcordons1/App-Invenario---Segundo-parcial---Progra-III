package com.v1k70r.controlinventario.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.v1k70r.controlinventario.domain.Product
import com.v1k70r.controlinventario.ui.theme.*

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().clickable { onClick() }.padding(16.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Column {
                Text(text = product.name, color = TextWhite, style = MaterialTheme.typography.titleMedium)
                Text(text = "${product.sku} - ${product.category}", color = TextGray, style = MaterialTheme.typography.bodySmall)
                Text(text = "Stock: ${product.currentStock}", color = if (product.currentStock <= product.minStock) PrimaryRed else TextGray)
            }
            Text(text = "Q${product.salePrice}", color = PrimaryRed, style = MaterialTheme.typography.titleMedium)
        }
        HorizontalDivider(modifier = Modifier.padding(top = 12.dp), color = DarkSurface)
    }
}