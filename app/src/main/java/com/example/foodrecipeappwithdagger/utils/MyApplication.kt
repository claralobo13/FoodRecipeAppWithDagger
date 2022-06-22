package com.example.foodrecipeappwithdagger.utils

import android.app.Application
import com.example.foodrecipeappwithdagger.di.DaggerRetroComponent
import com.example.foodrecipeappwithdagger.di.RetroComponent
import com.example.foodrecipeappwithdagger.di.RetroModule

class MyApplication: Application()  {

    private lateinit var retroComponent: RetroComponent

    override fun onCreate() {
        super.onCreate()
       retroComponent= DaggerRetroComponent.builder().retroModule(RetroModule()).build()
    }

    fun getRetroComponent():RetroComponent{
        return retroComponent
    }
}