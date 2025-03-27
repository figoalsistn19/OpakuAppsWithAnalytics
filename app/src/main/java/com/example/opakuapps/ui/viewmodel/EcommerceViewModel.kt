package com.example.opakuapps.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.opakuapps.data.Product

class EcommerceViewModel : ViewModel() {
    val toddlerProducts = listOf(
        Product(id = "1", name = "Pampers Premium Care (M-40)", price = 120000.0),
        Product(id = "2", name = "Pampers Premium Care (L-40)", price = 130000.0),
        Product(id = "3", name = "Pampers Premium Care (XL-40)", price = 140000.0),
        Product(id = "4", name = "Nutrilon Royal 3 Formula Milk (800gr)", price = 185000.0),
        Product(id = "5", name = "S-26 Procal Gold Formula Milk (900gr)", price = 195000.0),
        Product(id = "6", name = "Cerelac Baby Porridge Banana Flavor (120gr)", price = 25000.0),
        Product(id = "7", name = "Cerelac Baby Porridge Chicken Carrot Flavor (120gr)", price = 25000.0),
        Product(id = "8", name = "Pigeon Baby Wipes (80 pcs)", price = 30000.0),
        Product(id = "9", name = "Mitu Baby Wipes (80 pcs)", price = 28000.0),
        Product(id = "10", name = "Philips Avent Natural Baby Bottle (260ml)", price = 95000.0),
        Product(id = "11", name = "Pigeon Peristaltic Plus Baby Bottle (240ml)", price = 85000.0),
        Product(id = "12", name = "Long Sleeve Baby Clothes (3 pcs)", price = 150000.0),
        Product(id = "13", name = "Short Sleeve Baby Clothes (3 pcs)", price = 130000.0),
        Product(id = "14", name = "Baby Shorts (5 pcs)", price = 100000.0),
        Product(id = "15", name = "Baby Pants (5 pcs)", price = 120000.0),
        Product(id = "16", name = "Prewalker Baby Shoes", price = 75000.0),
        Product(id = "17", name = "Baby Socks (6 pairs)", price = 50000.0),
        Product(id = "18", name = "Cute Baby Hat", price = 40000.0),
        Product(id = "19", name = "Baby Blanket", price = 95000.0),
        Product(id = "20", name = "Baby Carrier Hipseat", price = 250000.0)
    )
}