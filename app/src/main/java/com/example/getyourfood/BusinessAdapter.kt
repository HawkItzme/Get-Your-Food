package com.example.getyourfood

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.getyourfood.databinding.ItemBusinessBinding
import com.example.getyourfood.model.Business

class BusinessAdapter(private val context: Context,
                      private val businesses: List<Business>
) : RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder>() {

    inner class BusinessViewHolder(val binding : ItemBusinessBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Business){
            binding.locationTV.text = item.location.address1
            binding.nameTV.text = item.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ItemBusinessBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.item_business,
            parent,
            false
        )
        return BusinessViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return businesses.size
    }

    override fun onBindViewHolder(holder: BusinessViewHolder, position: Int) {
        holder.bind(businesses[position])
    }

}