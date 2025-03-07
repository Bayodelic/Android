package com.example.ejemplo1.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
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
import com.example.ejemplo1.data.Receta
import com.example.ejemplo1.data.recetas
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

@Composable
fun ListaRecetasScreen(navController: NavController, recetas: List<Receta>) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(recetas) { receta ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { navController.navigate("detalle/${receta.nombre}") },
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF3E0)),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {
                Row(modifier = Modifier.padding(16.dp)) {
                    Image(
                        painter = painterResource(receta.imagen),
                        contentDescription = receta.nombre,
                        modifier = Modifier.size(80.dp).padding(end = 8.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column {
                        Text(text = receta.nombre, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        Text(text = receta.descripcion, fontSize = 14.sp, color = Color.Gray)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListaRecetas() {
    Ejemplo1Theme {
        ListaRecetasScreen(navController = rememberNavController(), recetas = recetas)
    }
}


