package com.example.foodrecipeappwithdagger.view


import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodrecipeappwithdagger.R
import com.example.foodrecipeappwithdagger.adapter.RecipeAdapter
import com.example.foodrecipeappwithdagger.model.RecyclerList
import com.example.foodrecipeappwithdagger.viewmodel.RecipeListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var recipeListViewModel: RecipeListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initViewModel()
    }
    private fun initViewModel() {
        recipeListViewModel= ViewModelProvider(this).get(RecipeListViewModel::class.java)
        recipeListViewModel.getLiveDataObserver().observe(this,object : Observer<RecyclerList> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onChanged(t: RecyclerList?) {
                if(t!=null){
                    recipeAdapter.setUpData(t.results)
                    recipeAdapter.notifyDataSetChanged()
                }else{
                    Toast.makeText(this@MainActivity,"error in getting data", Toast.LENGTH_SHORT).show()
                }
            }
        })
        recipeListViewModel.makeApiCall()
    }

    private fun initRecyclerView(){
        recyclerView.layoutManager= LinearLayoutManager(this)
        recipeAdapter= RecipeAdapter()
        recyclerView.adapter= recipeAdapter
    }
}