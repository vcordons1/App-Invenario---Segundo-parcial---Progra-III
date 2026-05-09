package com.v1k70r.controlinventario.ui.add

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.v1k70r.controlinventario.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProductScreen(viewModel: AddProductViewModel, onSave: () -> Unit, onBack: () -> Unit) {
    var name by remember { mutableStateOf("") }
    var sku by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var salePrice by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    var minStock by remember { mutableStateOf("") }

    Scaffold(
        containerColor = DarkBG,
        topBar = {
            TopAppBar(
                title = { Text("Nuevo producto", color = TextWhite) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = DarkSurface),
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null, tint = TextWhite)
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp).fillMaxSize(), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            OutlinedTextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(value = sku, onValueChange = { sku = it }, label = { Text("SKU") }, modifier = Modifier.fillMaxWidth())

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                OutlinedTextField(value = salePrice, onValueChange = { salePrice = it }, label = { Text("Precio Q") }, modifier = Modifier.weight(1f))
                OutlinedTextField(value = stock, onValueChange = { stock = it }, label = { Text("Stock") }, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.weight(1f))
            Button(onClick = { viewModel.saveProduct(name, sku, category, salePrice, "0", stock, minStock); onSave() }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = PrimaryRed)) {
                Text("GUARDAR PRODUCTO")
            }
        }
    }
}