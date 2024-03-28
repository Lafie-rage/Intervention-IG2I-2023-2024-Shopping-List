package fr.lafie.rage.myshoppinglist.data.dto

import java.util.UUID

data class ShoppingList(
    val id: UUID,
    val items: List<ShoppingItem>,
)
