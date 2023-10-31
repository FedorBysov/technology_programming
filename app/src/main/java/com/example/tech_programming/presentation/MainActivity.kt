package com.example.tech_programming.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tech_programming.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.bottomBar.setOnItemSelectedListener {
            when (it.itemId) {

                else -> {}
            }
            true
        }

    }

}