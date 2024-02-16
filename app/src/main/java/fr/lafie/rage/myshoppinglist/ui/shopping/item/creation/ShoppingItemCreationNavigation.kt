package fr.lafie.rage.myshoppinglist.ui.shopping.item.creation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ShoppingItemCreationRoute = "item-creation"
fun NavGraphBuilder.shoppingItemCreationNavigation(
    onNavigateToShoppingList: () -> Unit,
) {
    composable(ShoppingItemCreationRoute) {
        ShoppingItemCreationPage(onNavigateToShoppingList = onNavigateToShoppingList)
    }
}

fun NavController.navigateToShoppingItemCreation() {
    navigate(ShoppingItemCreationRoute)
}