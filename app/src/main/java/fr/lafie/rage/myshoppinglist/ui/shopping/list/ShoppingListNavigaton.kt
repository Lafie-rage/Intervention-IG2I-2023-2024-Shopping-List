package fr.lafie.rage.myshoppinglist.ui.shopping.list

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val ShoppingListRoute = "shopping-list"

fun NavGraphBuilder.shoppingListNavigation(
    shoppingListViewModel: ShoppingListViewModel,
    onNavigateToShoppingItemCreation: () -> Unit,
) {
    composable(ShoppingListRoute) {
        val state: ShoppingListState by shoppingListViewModel.state.collectAsStateWithLifecycle()
        ShoppingListPage(
            state = state,
            onNavigateToShoppingItemCreation = onNavigateToShoppingItemCreation,
        )
    }
}