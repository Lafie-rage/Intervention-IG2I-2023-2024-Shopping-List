package fr.lafie.rage.myshoppinglist.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    private val retrofitClient: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("http://162.19.231.177:5632")
        .build()

    val shoppingListService = retrofitClient.create(ShoppingListService::class.java)

    val shoppingItemService = retrofitClient.create(ShoppingItemService::class.java)
}