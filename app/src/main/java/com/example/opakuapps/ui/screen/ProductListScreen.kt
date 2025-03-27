package com.example.opakuapps.ui.screen

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.opakuapps.data.Product
import com.example.opakuapps.data.logAddToCart
import com.example.opakuapps.data.logProductView
import com.example.opakuapps.ui.viewmodel.EcommerceViewModel
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

@Composable
fun ProductListScreen(
    viewModel: EcommerceViewModel,
    analytics: FirebaseAnalytics,
) {
    var products by remember { mutableStateOf(
        listOf<Product>()
    ) }
    var showCheckoutScreen by remember { mutableStateOf(false) }
    var totalPrice by remember { mutableDoubleStateOf(0.0) }
    Column(modifier = Modifier.fillMaxSize()) {
        Text("Opaku Toddler Apps", style = MaterialTheme.typography.headlineMedium)
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(viewModel.toddlerProducts) { product ->
                ProductItem(
                    product = product,
                    onAddToCart = {
                        totalPrice += product.price
                        logAddToCart(analytics, product)
                        products += product
                    },
                    onBuyNow = {
                        totalPrice = product.price
                        showCheckoutScreen = true
                    }
                )
            }
        }

        if (totalPrice > 0) {
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ){
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp).weight(1f),
                    onClick = {
                        totalPrice = 0.0
                        products = listOf()
                        showCheckoutScreen = false
                    }
                ) {
                    Text("Delete item")
                }
                Button(
                    modifier = Modifier.fillMaxWidth().padding(16.dp).weight(2f),
                    onClick = {
//                        navController.navigate("checkout/${totalPrice.toFloat()}")
                        showCheckoutScreen = true
                    }
                ) {
                    Text("Checkout (IDR $totalPrice)")
                }
            }
        }
        if (showCheckoutScreen){
            CheckoutScreen(totalPrice,analytics,products)
        }
    }
}

@Composable
fun ProductItem(product: Product, onAddToCart: () -> Unit, onBuyNow: () -> Unit) {
    val analytics = Firebase.analytics

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .clickable {
                logProductView(analytics, product)
            }
            .padding(16.dp)
    ) {
        Text(text = product.name, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Text(text = "IDR ${product.price}", fontSize = 16.sp, color = MaterialTheme.colorScheme.primary)

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onAddToCart) {
                Text("Add to Cart")
            }
            Button(onClick = onBuyNow) {
                Text("Buy Now")
            }
        }
    }
}