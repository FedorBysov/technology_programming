package com.example.shopinglist.domain

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.Repository
import javax.inject.Inject

class GetShopNameListUseCase @Inject constructor(private val repository: Repository) {

    fun getShopNameListUseCase():LiveData<List<ShopName>>{
        return repository.getShopNameList()
    }
}