package fr.lafie.rage.myshoppinglist.data.service

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.shared.toDto
import fr.lafie.rage.myshoppinglist.ui.shopping.item.creation.ShoppingItemCreationState
import java.util.UUID

private val mockedShoppingListDataBase = mutableListOf(
    ShoppingItem(
        id = UUID.randomUUID(),
        label = "Pomme de terre",
        count = 1f,
        unit = "Kg",
    ),
    ShoppingItem(
        id = UUID.randomUUID(),
        label = "Fraise",
        count = 500f,
        unit = "g",
    ),
    ShoppingItem(
        id = UUID.randomUUID(),
        label = "Lait",
        count = 1f,
        unit = "L",
    ),
    ShoppingItem(
        id = UUID.randomUUID(),
        label = "Eau",
        count = 1.5f,
        unit = "L",
    ),
)

fun retrieveShoppingList(): List<ShoppingItem> = mockedShoppingListDataBase

fun addArticle(shoppingItem: ShoppingItemCreationState) {
    mockedShoppingListDataBase.add(shoppingItem.toDto(UUID.randomUUID()))
}