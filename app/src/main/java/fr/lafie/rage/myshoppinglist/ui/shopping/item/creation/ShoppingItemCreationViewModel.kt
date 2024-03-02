package fr.lafie.rage.myshoppinglist.ui.shopping.item.creation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import fr.lafie.rage.myshoppinglist.data.service.addArticle

class ShoppingItemCreationViewModel : ViewModel() {

    private val _shoppingItemCreationState: MutableState<ShoppingItemCreationState> =
        mutableStateOf(ShoppingItemCreationState())

    val shoppingItemCreationState: State<ShoppingItemCreationState>
        get() = _shoppingItemCreationState

    fun changeItemLabel(label: String) {
        _shoppingItemCreationState.value = shoppingItemCreationState.value.copy(label = label)
    }

    fun changeItemCount(count: String) {
        _shoppingItemCreationState.value = shoppingItemCreationState.value.copy(count = count)

    }

    fun changeItemUnit(unit: String) {
        _shoppingItemCreationState.value = shoppingItemCreationState.value.copy(unit = unit)
    }

    fun createItem() {
        addArticle(shoppingItemCreationState.value)
        // Clear state
        _shoppingItemCreationState.value = ShoppingItemCreationState()
    }
}