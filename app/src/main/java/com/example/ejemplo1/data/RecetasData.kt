package com.example.ejemplo1.data

import com.example.ejemplo1.R

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

