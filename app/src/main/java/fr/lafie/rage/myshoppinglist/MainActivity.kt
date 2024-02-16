package fr.lafie.rage.myshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.lafie.rage.myshoppinglist.ui.page.ShoppingListPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NavHost(
                navController = rememberNavController(),
                startDestination = "shopping-list",
            ) {
                composable("shopping-list") {
                    ShoppingListPage()
                }
            }
        }
    }
}