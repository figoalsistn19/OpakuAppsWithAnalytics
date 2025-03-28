package com.example.opakuapps.ui.screen

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.opakuapps.data.Product
import com.example.opakuapps.data.logCheckout
import com.example.opakuapps.data.logProductView
import com.example.opakuapps.data.logPurchase
import com.google.firebase.analytics.FirebaseAnalytics

@Composable
fun CheckoutScreen(
    totalPrice: Double,
    analytics: FirebaseAnalytics,
    products: List<Product>,
    onPurchase: () -> Unit
) {
    var context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn {
            items(products){ product->
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
                        .padding(16.dp)
                ) {
                    Text(text = product.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(text = "IDR ${product.price}", fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)
                }
            }
        }

        Text(text = "Total: IDR $totalPrice", fontSize = 20.sp, fontWeight = FontWeight.Bold)

        Button(onClick = {
            logPurchase(analytics, products)
            logCheckout(analytics, totalPrice)
            onPurchase()
            Toast.makeText(context,"Item Berhasil di Checkout", Toast.LENGTH_SHORT ).show()
        }) {
            Text("Confirm Checkout")
        }
    }
}