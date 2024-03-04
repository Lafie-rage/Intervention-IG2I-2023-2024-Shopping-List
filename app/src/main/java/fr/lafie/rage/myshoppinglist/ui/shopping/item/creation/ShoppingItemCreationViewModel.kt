package fr.lafie.rage.myshoppinglist.ui.shopping.item.creation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.lafie.rage.myshoppinglist.data.service.RetrofitHelper
import fr.lafie.rage.myshoppinglist.shared.toDto
import kotlinx.coroutines.launch
import java.util.UUID

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
        viewModelScope.launch {
            RetrofitHelper.shoppingItemService.addShoppingItemOnShoppingList(
                UUID.fromString("83ac5009-3d41-462a-ae82-c1873868c65b"),
                shoppingItemCreationState.value.toDto(),
            )
            // Clear state
            _shoppingItemCreationState.value = ShoppingItemCreationState()
        }
    }
}