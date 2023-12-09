package com.example.getyourfood.View

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getyourfood.R
import com.example.getyourfood.databinding.ItemBusinessBinding
import com.example.getyourfood.data.model.Business

class BusinessAdapter(
    private val businesses: List<Business>,
    private val onItemClick: (Business) -> Unit
) : RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder>() {

    inner class BusinessViewHolder(val binding : ItemBusinessBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Business){
            binding.locationTV.text = item.location.address1
            binding.nameTV.text = item.name
            Glide.with(binding.picIV.context)
                .load(item.image_url)
                .into(binding.picIV)
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

        holder.itemView.setOnClickListener {
            onItemClick.invoke(businesses[position])
        }
    }

}