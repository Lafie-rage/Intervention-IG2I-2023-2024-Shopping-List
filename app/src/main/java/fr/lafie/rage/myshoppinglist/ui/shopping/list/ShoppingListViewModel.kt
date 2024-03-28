package fr.lafie.rage.myshoppinglist.ui.shopping.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.data.service.RetrofitHelper
import fr.lafie.rage.myshoppinglist.shared.toState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class ShoppingListViewModel : ViewModel() {
    private val _state = MutableStateFlow(ShoppingListState())
    val state: StateFlow<ShoppingListState>
        get() {
            return _state.asStateFlow()
        }

    fun fetchShoppingList() {
        viewModelScope.launch {
            val shoppingList = RetrofitHelper.shoppingListService
                .getShoppingListById(
                    UUID.fromString("83ac5009-3d41-462a-ae82-c1873868c65b")
                ).items.map(ShoppingItem::toState)
            _state.update { current ->
                current.copy(shoppingList = shoppingList)
            }
        }
    }

}