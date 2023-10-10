package com.example.cafeshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Cafe(val name: String, val address: String, val rating: Float, val imageUrl: Int)

@Composable
fun CafeList() {
    val cafes = remember {
        listOf(
            Cafe("Cafe 1", "123 Main St", 4.5f, R.drawable.images),
            Cafe("Cafe 2", "456 Elm St", 3.8f, R.drawable.images2),
        )
    }

    LazyColumn {
        items(cafes) { cafe ->
            CafeCard(cafe = cafe)
        }
    }
}

@Composable
fun CafeCard(cafe: Cafe) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = cafe.imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = cafe.name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(text = cafe.address, color = Color.Gray)

            Spacer(modifier = Modifier.height(8.dp))

            RatingBar(rating = cafe.rating)

            Spacer(modifier = Modifier.height(16.dp))

            Divider(
                color = Color.Gray,
                thickness = 0.5.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            Button(
                onClick = { /* Reserva */ },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(text = "Reservar")
            }
        }
    }
}

@Composable
fun RatingBar(rating: Float) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Calificación: ")

        RatingBarIndicator(rating = rating)
    }
}

@Composable
fun RatingBarIndicator(rating: Float) {
}