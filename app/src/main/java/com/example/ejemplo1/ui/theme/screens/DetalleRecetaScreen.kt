package com.example.ejemplo1.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo1.data.recetas
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

@Composable
fun DetalleRecetaScreen(recetaNombre: String?, navController: NavController) {
    val receta = recetas.find { it.nombre == recetaNombre } ?: return

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF00796B))
        ) {
            Text(text = "Regresar", color = Color.White)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(receta.imagen),
            contentDescription = receta.nombre,
            modifier = Modifier.fillMaxWidth().height(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = receta.nombre, fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF00796B))
        Text(text = receta.descripcion, fontSize = 16.sp, modifier = Modifier.padding(vertical = 8.dp))
        Text(text = "Ingredientes:", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color(0xFFE64A19))
        Column(modifier = Modifier.padding(top = 8.dp)) {
            receta.ingredientes.forEach {
                Text(text = "- $it", fontSize = 16.sp, color = Color.DarkGray)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetalleReceta() {
    Ejemplo1Theme {
        DetalleRecetaScreen(recetaNombre = "Spaghetti", navController = rememberNavController())
    }
}
