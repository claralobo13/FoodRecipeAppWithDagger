package com.example.foodrecipeappwithdagger.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.foodrecipeappwithdagger.model.RecyclerList
import com.example.foodrecipeappwithdagger.network.RetroServiceInterface
import com.example.foodrecipeappwithdagger.utils.Constants.API_KEY
import com.example.foodrecipeappwithdagger.utils.Constants.NUMBER
import com.example.foodrecipeappwithdagger.utils.MyApplication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RecipeListViewModel(application: Application): AndroidViewModel(application) {
    @Inject
    lateinit var mService: RetroServiceInterface
    private lateinit var liveData: MutableLiveData<RecyclerList>
    init {
        (application as MyApplication).getRetroComponent().inject(this)
        liveData= MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<RecyclerList> {
        return liveData
    }
    fun makeApiCall(){
        viewModelScope.launch(Dispatchers.IO){
            val response=  mService.getRecipes(API_KEY, NUMBER)
            liveData.postValue(response)
        }





    }
}