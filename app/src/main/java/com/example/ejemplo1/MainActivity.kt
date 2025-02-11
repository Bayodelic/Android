package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.text.font.FontWeight


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.setContent {
            Ejemplo1Theme {
                GreetingPreview()
            }
        }
    }
}


@Composable
fun Content(mensaje1: String, mensaje2: String) {
    Row{
        Text(
            mensaje1,
            fontSize = 30.sp
        )
        Text(
            mensaje2,
            lineHeight = 30.sp
        )
        Text("Yisus", fontWeight = FontWeight.Bold, fontSize = 30.sp, lineHeight = 30.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Content("Hola","asas")
}