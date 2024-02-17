package fr.lafie.rage.myshoppinglist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import fr.lafie.rage.myshoppinglist.ui.shopping.item.creation.ShoppingItemCreationViewModel
import fr.lafie.rage.myshoppinglist.ui.shopping.item.creation.navigateToShoppingItemCreation
import fr.lafie.rage.myshoppinglist.ui.shopping.item.creation.shoppingItemCreationNavigation
import fr.lafie.rage.myshoppinglist.ui.shopping.list.ShoppingListViewModel
import fr.lafie.rage.myshoppinglist.ui.shopping.list.shoppingListNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val shoppingListViewModel by viewModels<ShoppingListViewModel>()
            val shoppingItemCreationViewModel by viewModels<ShoppingItemCreationViewModel>()
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "shopping-list",
            ) {
                shoppingListNavigation(
                    shoppingListViewModel = shoppingListViewModel,
                    onNavigateToShoppingItemCreation = navController::navigateToShoppingItemCreation
                )
                shoppingItemCreationNavigation(
                    shoppingItemCreationViewModel = shoppingItemCreationViewModel,
                    onNavigateToShoppingList = { navController.navigateUp() }
                )
            }
        }
    }
}