package fr.lafie.rage.myshoppinglist.shared

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItemToCreate
import fr.lafie.rage.myshoppinglist.ui.shopping.item.creation.ShoppingItemCreationState
import fr.lafie.rage.myshoppinglist.ui.shopping.list.ShoppingItemState

fun ShoppingItem.toState() = ShoppingItemState(
    id = id,
    label = label,
    count = count,
    unit = unit,
)

fun ShoppingItemCreationState.toDto() = ShoppingItemToCreate(
    label = label,
    count = count.toFloat(),
    unit = unit,
)