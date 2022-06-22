package com.example.foodrecipeappwithdagger.model

data class RecyclerList(val results: ArrayList<RecyclerData>)
data class RecyclerData(val title: String, val image: String)