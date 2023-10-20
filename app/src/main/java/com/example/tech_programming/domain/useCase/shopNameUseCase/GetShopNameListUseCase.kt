package com.example.shopinglist.domain

import androidx.lifecycle.LiveData
import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.repository.ShopNameRepository
import javax.inject.Inject

class GetShopNameListUseCase @Inject constructor(private val shopNameRepository: ShopNameRepository) {

    fun getShopNameListUseCase():LiveData<List<ShopName>>{
        return shopNameRepository.getShopNameList()
    }
}