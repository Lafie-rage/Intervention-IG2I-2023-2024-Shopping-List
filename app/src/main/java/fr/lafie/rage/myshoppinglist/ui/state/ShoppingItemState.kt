package fr.lafie.rage.myshoppinglist.ui.state

data class ShoppingItemState(
    val id: Int,
    val label: String,
    val count: Float,
    val unit: String,
)