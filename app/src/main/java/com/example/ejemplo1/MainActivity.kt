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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Imagen en la parte superior con tamaño adecuado
        SimpleImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp) // Ajusta la altura según sea necesario
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Campos de texto y botón
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextFieldWithInputType()
            Spacer(modifier = Modifier.height(16.dp))
            TextFieldWithInputType2()
            Spacer(modifier = Modifier.height(16.dp))
            SimpleButton()
        }
    }
}

@Composable
fun SimpleImage(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(id = R.drawable.carro),
        contentDescription = "un carro chidote",
        modifier = modifier,
        contentScale = ContentScale.Crop  // Ajusta la imagen para cubrir sin deformarse
    )
}

@Composable
fun TextFieldWithInputType() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Valor 1") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }

    )
}

@Composable
fun TextFieldWithInputType2() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = "Valor 2") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        }
    )
}
@Composable
fun SimpleButton() {
    Button(onClick = {
        //your onclick code here
    }
    ) {
        Text(text = "Calcular")
    }
}
