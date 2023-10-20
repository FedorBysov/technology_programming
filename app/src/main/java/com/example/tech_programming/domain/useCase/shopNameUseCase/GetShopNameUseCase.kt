package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.repository.ShopNameRepository
import com.example.tech_programming.domain.repository.StorageItemRepository
import javax.inject.Inject

class GetShopNameUseCase @Inject constructor(private val shopNameRepository: ShopNameRepository) {


    suspend fun getShopNameUseCase(shopNameId:Int):ShopName{
        return shopNameRepository.getShopName(shopNameId)
    }

}



