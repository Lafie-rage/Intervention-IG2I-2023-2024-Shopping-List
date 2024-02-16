package fr.lafie.rage.myshoppinglist.data.service

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem

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