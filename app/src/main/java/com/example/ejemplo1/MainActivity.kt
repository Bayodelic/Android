package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    var precio by remember { mutableStateOf(TextFieldValue("")) }
    var descuento by remember { mutableStateOf(TextFieldValue("")) }
    var precioFinal by remember { mutableStateOf(0.0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen decorativa
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.carro),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para ingresar el precio del producto
        TextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text(text = "Precio del producto") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campo para ingresar el porcentaje de descuento
        TextField(
            value = descuento,
            onValueChange = { descuento = it },
            label = { Text(text = "Descuento (%)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botón para calcular el precio final con descuento
        Button(
            onClick = {
                val precioProducto = precio.text.toDoubleOrNull() ?: 0.0
                val porcentajeDescuento = descuento.text.toDoubleOrNull() ?: 0.0
                precioFinal = precioProducto - (precioProducto * (porcentajeDescuento / 100))
            },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = "Calcular descuento")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar precio final
        Text(
            text = "Precio final: $${"%.2f".format(precioFinal)}",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}