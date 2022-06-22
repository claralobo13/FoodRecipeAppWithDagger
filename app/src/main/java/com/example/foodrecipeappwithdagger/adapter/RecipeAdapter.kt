package com.example.foodrecipeappwithdagger.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodrecipeappwithdagger.R
import com.example.foodrecipeappwithdagger.model.RecyclerData
import kotlinx.android.synthetic.main.recycler_list_row.view.*

class RecipeAdapter : RecyclerView.Adapter<RecipeAdapter.MyViewHolder>(){
    private var listData: ArrayList<RecyclerData>?=null

    fun setUpData(listData: ArrayList<RecyclerData>){
        this.listData=listData
    }


    class MyViewHolder(view: View): RecyclerView.ViewHolder(view){

        val imageView= view.imageThumb
        val title= view.title
        fun bind(data:RecyclerData){
            title.setText(data.title)
            Glide.with(imageView)
                .load(data.image)
                .into(imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)

    }

    override fun getItemCount(): Int {
        if(listData==null)return 0
        else return listData?.size!!
    }

}