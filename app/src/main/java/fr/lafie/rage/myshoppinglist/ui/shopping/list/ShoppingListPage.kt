package fr.lafie.rage.myshoppinglist.ui.shopping.list

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.lafie.rage.myshoppinglist.R
import fr.lafie.rage.myshoppinglist.ui.shared.component.ShoppingItemCard
import fr.lafie.rage.myshoppinglist.ui.shared.theme.MyShoppingListTheme

@Composable
fun ShoppingListPage(
    state: ShoppingListState,
    fetchShoppingList: () -> Unit,
    onNavigateToShoppingItemCreation: () -> Unit,
) {
    LaunchedEffect(Unit) {
        fetchShoppingList()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.padding(8.dp),
                onClick = onNavigateToShoppingItemCreation,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(id = R.string.shopping_list_add_button_description)
                )
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(padding),
        ) {
            items(state.shoppingList) { shoppingItem ->
                ShoppingItemCard(shoppingItem = shoppingItem)
            }
        }
    }
}

@Composable
@Preview
fun ShoppingListPagePreview() {
    MyShoppingListTheme {
        ShoppingListPage(
            state = ShoppingListState(
                listOf(
                    ShoppingItemState(
                        id = 0,
                        label = "Pomme de terre",
                        count = 1f,
                        unit = "Kg",
                    ),
                    ShoppingItemState(
                        id = 0,
                        label = "Lait",
                        count = 1.5f,
                        unit = "L",
                    ),
                )
            ),
            fetchShoppingList = {},
            onNavigateToShoppingItemCreation = {}
        )
    }
}