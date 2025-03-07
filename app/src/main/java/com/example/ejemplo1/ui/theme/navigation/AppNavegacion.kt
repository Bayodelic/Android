package com.example.ejemplo1.ui.theme.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo1.data.recetas
import com.example.ejemplo1.ui.theme.Ejemplo1Theme
import com.example.ejemplo1.ui.theme.screens.DetalleRecetaScreen
import com.example.ejemplo1.ui.theme.screens.ListaRecetasScreen

@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "lista") {
        composable("lista") { ListaRecetasScreen(navController, recetas) }
        composable("detalle/{recetaNombre}") { backStackEntry ->
            DetalleRecetaScreen(backStackEntry.arguments?.getString("recetaNombre"), navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAppNavegacion() {
    Ejemplo1Theme {
        AppNavegacion()
    }
}