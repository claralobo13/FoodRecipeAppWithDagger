package com.example.foodrecipeappwithdagger.network

import com.example.foodrecipeappwithdagger.model.RecyclerList
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

//interface to access the endpoints from the API, function getRecipes whose implementation will be provided by Retrofit

interface RetroServiceInterface {

    @GET("recipes/complexSearch")

    //It returns response of type RecyclerList model, suspend indicates use of coroutines
   suspend fun getRecipes(@Query("apiKey") api_key: String?,
                   @Query("number") number: Int): RecyclerList

}