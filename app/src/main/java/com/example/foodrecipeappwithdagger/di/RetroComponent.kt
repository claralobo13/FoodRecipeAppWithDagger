package com.example.foodrecipeappwithdagger.di


import com.example.foodrecipeappwithdagger.viewmodel.RecipeListViewModel
import dagger.Component
import javax.inject.Singleton

//interface annotated with @component which mention the classes where Module class will be used
// modules few objects are scoped so annotated interface with @Singleton
@Singleton
@Component(modules=[RetroModule::class])
interface RetroComponent {
    //using filed injection ViewModel field will be annotated with @Inject, when Dagger find those that will be intialised
    fun inject(recipeListViewModel: RecipeListViewModel){

        }
}