package com.example.opakuapps.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.opakuapps.data.Product
import com.example.opakuapps.data.logCheckout
import com.example.opakuapps.data.logPurchase
import com.google.firebase.analytics.FirebaseAnalytics

@Composable
fun CheckoutScreen(totalPrice: Double, analytics: FirebaseAnalytics, products: List<Product>) {
//    val analytics = Firebase.analytics

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Total: IDR $totalPrice", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Button(onClick = {
            logPurchase(analytics, products)
            logCheckout(analytics, totalPrice)
        }) {
            Text("Confirm Checkout")
        }
    }
}