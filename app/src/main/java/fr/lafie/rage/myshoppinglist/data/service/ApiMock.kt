package fr.lafie.rage.myshoppinglist.data.service

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.shared.toDto
import fr.lafie.rage.myshoppinglist.ui.shopping.item.creation.ShoppingItemCreationState

private val mockedShoppingListDataBase = mutableListOf(
    ShoppingItem(
        id = 0,
        label = "Pomme de terre",
        count = 1f,
        unit = "Kg",
    ),
    ShoppingItem(
        id = 0,
        label = "Fraise",
        count = 500f,
        unit = "g",
    ),
    ShoppingItem(
        id = 0,
        label = "Lait",
        count = 1f,
        unit = "L",
    ),
    ShoppingItem(
        id = 0,
        label = "Eau",
        count = 1.5f,
        unit = "L",
    ),
)

fun retrieveShoppingList(): List<ShoppingItem> = mockedShoppingListDataBase

fun addArticle(shoppingItem: ShoppingItemCreationState) {
    mockedShoppingListDataBase.add(shoppingItem.toDto(getNextUnusedId()))
}

private fun getNextUnusedId(): Int = mockedShoppingListDataBase.maxOf { it.id }.inc()