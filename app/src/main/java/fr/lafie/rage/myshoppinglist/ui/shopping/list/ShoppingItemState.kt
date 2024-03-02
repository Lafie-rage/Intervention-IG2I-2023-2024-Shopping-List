package fr.lafie.rage.myshoppinglist.ui.shopping.list

import java.util.UUID

data class ShoppingItemState(
    val id: UUID,
    val label: String,
    val count: Float,
    val unit: String,
)