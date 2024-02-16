package fr.lafie.rage.myshoppinglist.shared

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.ui.state.ShoppingItemState

fun ShoppingItem.toState() = ShoppingItemState(
    id = id,
    label = label,
    count = count,
    unit = unit,
)