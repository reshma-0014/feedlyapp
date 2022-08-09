package com.example.feedlyapp.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feedlyapp.R
import com.example.feedlyapp.databinding.HeadlineItemsBinding
import com.example.feedlyapp.network.Model

class Adapter(val modelList: List<Model>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ViewHolder).bind(modelList.get(position));
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(HeadlineItemsBinding.inflate(layoutInflater, parent, false))
    }

    override fun getItemCount(): Int {
        return modelList.size;
    }



}
class ViewHolder(val binding: HeadlineItemsBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(model: Model): Unit {
        binding.viewModel= model
    }

}