package com.example.tech_programming.presentation.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.tech_programming.databinding.ItemCardBinding

class ViewHolder(binding: ItemCardBinding) : RecyclerView.ViewHolder(binding.root) {
    val text = binding.textNote
    val count = binding.count
}