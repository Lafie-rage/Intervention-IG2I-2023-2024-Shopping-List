package fr.lafie.rage.myshoppinglist.data.service

import fr.lafie.rage.myshoppinglist.data.dto.ShoppingList
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.UUID

interface ShoppingListService {
    @GET("shopping-lists/{id}")
    suspend fun getShoppingListById(
        @Path("id") id: UUID,
    ): ShoppingList
}