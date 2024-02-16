package fr.lafie.rage.myshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.lafie.rage.myshoppinglist.ui.shopping.list.ShoppingListPage
import fr.lafie.rage.myshoppinglist.ui.shopping.list.ShoppingListState
import fr.lafie.rage.myshoppinglist.ui.shopping.list.ShoppingListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val shoppingListViewModel by viewModels<ShoppingListViewModel>()


            NavHost(
                navController = rememberNavController(),
                startDestination = "shopping-list",
            ) {
                composable("shopping-list") {
                    val state: ShoppingListState by shoppingListViewModel.state.collectAsStateWithLifecycle()
                    ShoppingListPage(state)
                }
            }
        }
    }
}