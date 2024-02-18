package fr.lafie.rage.myshoppinglist.ui.shopping.list

import androidx.lifecycle.ViewModel
import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItem
import fr.lafie.rage.myshoppinglist.data.service.retrieveShoppingList
import fr.lafie.rage.myshoppinglist.shared.toState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ShoppingListViewModel : ViewModel() {
    private val _state = MutableStateFlow(ShoppingListState())
    val state: StateFlow<ShoppingListState>
        get() {
            return _state.asStateFlow()
        }

    fun fetchShoppingList() {
        _state.update { current ->
            current.copy(shoppingList = retrieveShoppingList().map(ShoppingItem::toState))
        }
    }

}