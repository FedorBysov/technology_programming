package com.example.tech_programming.presentation.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tech_programming.R

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val text = view.findViewById<TextView>(R.id.textNote)
    val count = view.findViewById<TextView>(R.id.count)
}