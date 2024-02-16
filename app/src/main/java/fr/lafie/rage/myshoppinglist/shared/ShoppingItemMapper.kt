package fr.lafie.rage.myshoppinglist.shared

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.ui.shopping.list.ShoppingItemState

fun ShoppingItem.toState() = ShoppingItemState(
    id = id,
    label = label,
    count = count,
    unit = unit,
)