package com.example.tech_programming.presentation.shopNameFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.AddShopNameUseCase
import com.example.shopinglist.domain.EditShopNameListUseCase
import com.example.shopinglist.domain.GetShopNameUseCase
import com.example.tech_programming.domain.model.ShopName
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShopNameAddEditViewModel @Inject constructor(
    private val getShopNameUseCase: GetShopNameUseCase ,
    private val addShopNameUseCase: AddShopNameUseCase ,
    private val editShopNameListUseCase: EditShopNameListUseCase
) : ViewModel() {


    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _shopNameItem = MutableLiveData<ShopName>()
    val storageItem: LiveData<ShopName>
        get() = _shopNameItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getStorageItem(shopNameId: Int) {
        viewModelScope.launch {
            val item = getShopNameUseCase.getShopNameUseCase(shopNameId)
            _shopNameItem.postValue(item)
        }

    }

    fun addShopName(inputName: String?) {
        val name = validateName(inputName)
        val fieldsValid = validateInput(name)
        if (fieldsValid) {
            viewModelScope.launch {
                val shopName = ShopName(name)
                addShopNameUseCase.addShopNameUseCase(shopName)
                finishWork()
            }
        }
    }

    fun editShopName(inputName: String?) {
        val name = validateName(inputName)
        if (validateInput(name)) {
            viewModelScope.launch {
                _shopNameItem.value?.let {
                    val item = it.copy(name)
                    editShopNameListUseCase.editShopNameListUseCase(item)
                    finishWork()
                }

            }
        }
    }

    fun validateName(inputName: String?): String {
        return inputName?.trim() ?: ""
    }


    fun validateInput(name: String): Boolean {
        var result = true
        if (name.isBlank()) {
            _errorInputName.value = true
            result = false
        }
        return result
    }

    fun resetInputName() {
        _errorInputName.value = false
    }


    fun finishWork() {
        _shouldCloseScreen.postValue(Unit)
    }
}