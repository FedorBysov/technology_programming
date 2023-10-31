package com.example.tech_programming.presentation

import android.app.Application
import com.example.tech_programming.di.DaggerApplicationComponent

class AppApplication : Application(){
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}