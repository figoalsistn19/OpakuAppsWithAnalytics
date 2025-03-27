package com.example.opakuapps

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.opakuapps.ui.screen.ProductListScreen
import com.example.opakuapps.ui.theme.OpakuAppsTheme
import com.example.opakuapps.ui.viewmodel.EcommerceViewModel
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val analytics = Firebase.analytics
        enableEdgeToEdge()
        setContent {
            OpakuAppsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    val viewModel: EcommerceViewModel = viewModel()
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "productList") {
                        composable("productList") {
                            ProductListScreen(viewModel, analytics)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    OpakuAppsTheme {
        Greeting("Android")
    }
}