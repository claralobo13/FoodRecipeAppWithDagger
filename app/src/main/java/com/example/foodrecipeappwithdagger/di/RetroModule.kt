package com.example.foodrecipeappwithdagger.di

import com.example.foodrecipeappwithdagger.network.RetroServiceInterface
import com.example.foodrecipeappwithdagger.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

//class which provides functions that can be injected where-ever we want, those functions annotated with @Provides
//@Singleton to create only one object
@Module
class RetroModule {
    //function provides Retrofit object, return type is retrofit
    @Singleton
    @Provides
    fun getRetrofitInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // function to provide implementation for API, Dagger will provide body the methods of RetroServiceInterface
    //using retrofit object from above function
    @Singleton
    @Provides
    fun  getRetroServiceInstance(retrofit: Retrofit): RetroServiceInterface{
        return retrofit.create(RetroServiceInterface::class.java)
    }
}