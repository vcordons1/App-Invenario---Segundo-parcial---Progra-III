package com.v1k70r.controlinventario

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.v1k70r.controlinventario.ui.theme.ControlInventarioTheme
import com.v1k70r.controlinventario.ui.inventory.*
import com.v1k70r.controlinventario.ui.detail.*
import com.v1k70r.controlinventario.ui.add.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ControlInventarioTheme {
                val navController = rememberNavController()
                val repository = DependencyProvider.repository

                NavHost(
                    navController = navController,
                    startDestination = "inventory"
                ) {
                    // Pantalla Principal: Listado de Inventario
                    composable(route = "inventory") {
                        InventoryScreen(
                            viewModel = remember { InventoryViewModel(repository) },
                            onProductClick = { id ->
                                navController.navigate("detail/$id")
                            },
                            onAddClick = {
                                navController.navigate("add")
                            }
                        )
                    }

                    // Pantalla de Detalle: Ver y ajustar stock
                    composable(
                        route = "detail/{id}",
                        arguments = listOf(
                            navArgument("id") { type = NavType.StringType }
                        )
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getString("id") ?: ""
                        DetailScreen(
                            productId = id,
                            viewModel = remember { DetailViewModel(repository) },
                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }

                    // Pantalla de Formulario: Agregar nuevo producto
                    composable(route = "add") {
                        AddProductScreen(
                            viewModel = remember { AddProductViewModel(repository) },
                            onSave = {
                                navController.popBackStack()
                            },
                            onBack = {
                                navController.popBackStack()
                            }
                        )
                    }
                }
            }
        }
    }
}
