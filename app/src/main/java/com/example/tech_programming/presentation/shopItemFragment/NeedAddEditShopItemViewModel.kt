package com.example.tech_programming.presentation.shopItemFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.AddShopItemUseCase
import com.example.shopinglist.domain.EditShopListItemUseCase
import com.example.shopinglist.domain.GetShopItemUseCase
import com.example.tech_programming.domain.model.ShopItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class NeedAddEditShopItemViewModel @Inject constructor(
    private val getShopItemUseCase: GetShopItemUseCase,
    private val addShopItemUseCase: AddShopItemUseCase,
    private val editShopListItemUseCase: EditShopListItemUseCase
) : ViewModel() {


    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _shopItem = MutableLiveData<ShopItem>()
    val shopItem: LiveData<ShopItem>
        get() = _shopItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getShopItem(requestItem: Int, shopId:Int) {
        viewModelScope.launch {
            val item = getShopItemUseCase.getShopItemUseCase(requestItem, shopId)
            _shopItem.postValue(item)
        }

    }

    fun addShopItem(inputName: String?, inputCount: String?, shopId: Int) {
        val name = validateName(inputName)
        val count = validateCount(inputCount)
        val fieldsValid = validateInput(name, count)
        if (fieldsValid) {
            viewModelScope.launch {
                val shopItem = ShopItem(name , count,  shopId )
                addShopItemUseCase.addShopItemUseCase(shopItem)
                finishWork()
            }
        }
    }

    fun editShopItem(inputName: String?, inputCount: String?) {
        val name = validateName(inputName)
        val count = validateCount(inputCount)
        if (validateInput(name, count)) {
            viewModelScope.launch {
                _shopItem.value?.let {
                    val item = it.copy(name, count)
                    editShopListItemUseCase.editShopListItemUseCase(item)
                    finishWork()
                }

            }
        }
    }

    fun validateName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }

    fun validateCount(inputCount: String?): Int {
        return try {
            inputCount?.trim()?.toInt() ?: 0
        } catch (e: java.lang.Exception) {
            0
        }
    }

    fun validateInput(name: String, count: Int): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        if (count <= 0) {
            _errorInputCount.value = true
            result = false
        }
        return result
    }

    fun resetInputName() {
        _errorInputName.value = false
    }

    fun resetInputCount() {
        _errorInputCount.value = false
    }

    fun finishWork() {
        _shouldCloseScreen.postValue(Unit)
    }
}