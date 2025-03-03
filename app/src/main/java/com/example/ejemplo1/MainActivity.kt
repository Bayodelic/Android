package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                AppNavegacion()
            }
        }
    }
}

data class Receta(
    val nombre: String,
    val descripcion: String,
    val ingredientes: List<String>,
    val imagen: Int
)

val recetas = listOf(
    Receta("Spaghetti", "Una deliciosa pasta italiana...",
        listOf("Pasta", "Tomate", "Queso", "Carne"), R.drawable.spaguetti),
    Receta("Hamburguesa", "Carne jugosa con pan y aderezos...",
        listOf("Carne", "Pan", "Lechuga", "Tomate"), R.drawable.hamburguesa),
    Receta("Pizza Margherita", "Pizza clásica italiana con queso y albahaca...",
        listOf("Masa", "Tomate", "Queso Mozzarella", "Albahaca"), R.drawable.pizza),
    Receta("Ensalada César", "Una ensalada fresca y deliciosa con aderezo césar...",
        listOf("Lechuga", "Pollo", "Pan Tostado", "Queso Parmesano"), R.drawable.ensalada)
)
@Composable
fun ListaRecetas(navController: NavController, recetas: List<Receta>) {
    LazyColumn {
        items(recetas) { receta ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detalle/${receta.nombre}") },
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(painter = painterResource(receta.imagen), contentDescription = receta.nombre,
                        modifier = Modifier.size(80.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = receta.nombre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }
        }
    }
}

@Composable
fun DetalleReceta(recetaNombre: String?, navController: NavController) {
    val receta = recetas.find { it.nombre == recetaNombre } ?: return

    Column(modifier = Modifier.padding(16.dp)) {
        Button(onClick = { navController.popBackStack() }, modifier = Modifier.padding(bottom = 16.dp)) {
            Text(text = "Regresar")
        }
        Image(painter = painterResource(receta.imagen), contentDescription = receta.nombre,
            modifier = Modifier.fillMaxWidth())
        Text(text = receta.nombre, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = receta.descripcion, fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Text(text = "Ingredientes:", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        receta.ingredientes.forEach {
            Text(text = "- $it", fontSize = 16.sp)
        }
    }
}


@Composable
fun AppNavegacion() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "lista") {
        composable("lista") { ListaRecetas(navController, recetas) }
        composable("detalle/{recetaNombre}") { backStackEntry ->
            DetalleReceta(backStackEntry.arguments?.getString("recetaNombre"), navController)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    Ejemplo1Theme {
        AppNavegacion()
    }
}
