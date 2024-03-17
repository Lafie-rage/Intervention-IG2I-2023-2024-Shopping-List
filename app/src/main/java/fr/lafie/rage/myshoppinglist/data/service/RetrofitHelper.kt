package fr.lafie.rage.myshoppinglist.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofitClient: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://10.0.2.2:8080")
        .build()

    val shoppingListService = retrofitClient.create(ShoppingListService::class.java)

    val shoppingItemService = retrofitClient.create(ShoppingItemService::class.java)
}