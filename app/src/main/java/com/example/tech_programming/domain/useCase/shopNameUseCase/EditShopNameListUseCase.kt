package com.example.shopinglist.domain

import com.example.tech_programming.domain.model.ShopName
import com.example.tech_programming.domain.repository.ShopNameRepository
import javax.inject.Inject

class EditShopNameListUseCase @Inject constructor(private val shopNameRepository: ShopNameRepository) {

    suspend fun editShopNameListUseCase(shopName: ShopName){
        shopNameRepository.editShopName(shopName)
    }

}