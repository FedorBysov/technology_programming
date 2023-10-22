package com.example.tech_programming.presentation.adapter

import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_programming.R
import com.example.tech_programming.databinding.ItemCardActivBinding

class ViewHolder(binding: ItemCardActivBinding) : RecyclerView.ViewHolder(binding.root) {
    val text = binding.textNote
    val count = binding.count
}