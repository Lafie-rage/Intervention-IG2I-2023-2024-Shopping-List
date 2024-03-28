package fr.lafie.rage.myshoppinglist.data.service

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingItemToCreate
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.UUID

interface ShoppingItemService {
    @POST("shopping-items")
    suspend fun addShoppingItemOnShoppingList(
        @Query("shoppingListId") shoppingListId: UUID,
        @Body itemToCreate: ShoppingItemToCreate,
    )
}