package com.example.task_123.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.task_123.R
import com.example.task_123.databinding.LanguageItemBinding
import com.example.task_123.model.LanguageModel

class LanguageAdapter(val list: List<LanguageModel>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.language_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class LanguageViewHolder(val binding: LanguageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(model: LanguageModel) {
            binding.model = model
        }
    }

}