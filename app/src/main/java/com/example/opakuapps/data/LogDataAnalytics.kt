package com.example.opakuapps.data

import android.os.Bundle
import android.util.Log
import com.google.firebase.analytics.FirebaseAnalytics

fun logProductView(analytics: FirebaseAnalytics, product: Product) {
    val bundle = Bundle().apply {
        putString(FirebaseAnalytics.Param.ITEM_ID, product.id)
        putString(FirebaseAnalytics.Param.ITEM_NAME, product.name)
        putDouble(FirebaseAnalytics.Param.PRICE, product.price)
    }
    analytics.logEvent(FirebaseAnalytics.Event.VIEW_ITEM, bundle)
    Log.d("Firebase", "item ${product.name} viewed")

}

fun logAddToCart(analytics: FirebaseAnalytics, product: Product) {
    val bundle = Bundle().apply {
        putString(FirebaseAnalytics.Param.ITEM_ID, product.id)
        putString(FirebaseAnalytics.Param.ITEM_NAME, product.name)
        putDouble(FirebaseAnalytics.Param.PRICE, product.price)
    }
    analytics.logEvent(FirebaseAnalytics.Event.ADD_TO_CART, bundle)
    Log.d("Firebase", "item ${product.name} add to cart")

}

fun logCheckout(analytics: FirebaseAnalytics, totalPrice: Double) {
    val bundle = Bundle().apply {
        putDouble(FirebaseAnalytics.Param.VALUE, totalPrice)
        putString(FirebaseAnalytics.Param.CURRENCY, "IDR")
    }
    analytics.logEvent(FirebaseAnalytics.Event.BEGIN_CHECKOUT, bundle)
    Log.d("Firebase", "Get Rp.${totalPrice}")
}

fun logPurchase(analytics: FirebaseAnalytics, products: List<Product>) {
    products.forEach{ product ->
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.ITEM_ID, product.id)
            putString(FirebaseAnalytics.Param.ITEM_NAME, product.name)
            putDouble(FirebaseAnalytics.Param.PRICE, product.price)
            putString(FirebaseAnalytics.Param.CURRENCY, "IDR")
        }
        analytics.logEvent(FirebaseAnalytics.Event.PURCHASE, bundle)
        Log.d("Firebase", "item ${product.name} purchased")
    }
}