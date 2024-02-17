package fr.lafie.rage.myshoppinglist.ui.shopping.item.creation

import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ShoppingItemCreationRoute = "item-creation"
fun NavGraphBuilder.shoppingItemCreationNavigation(
    shoppingItemCreationViewModel: ShoppingItemCreationViewModel,
    onNavigateToShoppingList: () -> Unit,
) {
    composable(ShoppingItemCreationRoute) {
        val state: ShoppingItemCreationState by shoppingItemCreationViewModel.shoppingItemCreationState
        ShoppingItemCreationPage(
            state = state,
            changeItemLabel = shoppingItemCreationViewModel::changeItemLabel,
            changeItemCount = shoppingItemCreationViewModel::changeItemCount,
            changeItemUnit = shoppingItemCreationViewModel::changeItemUnit,
            createItem = shoppingItemCreationViewModel::createItem,
            onNavigateToShoppingList = onNavigateToShoppingList,
        )
    }
}

fun NavController.navigateToShoppingItemCreation() {
    navigate(ShoppingItemCreationRoute)
}