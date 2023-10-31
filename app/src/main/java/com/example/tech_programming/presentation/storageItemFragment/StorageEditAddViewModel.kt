package com.example.tech_programming.presentation.storageItemFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopinglist.domain.AddStorageItemUseCase
import com.example.shopinglist.domain.EditStorageItemListUseCase
import com.example.tech_programming.domain.model.StorageItem
import com.example.tech_programming.domain.useCase.storageItemUseCase.GetStorageItemUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class StorageEditAddViewModel @Inject constructor(
    private val getShopItemUseCase : GetStorageItemUseCase,
    private val addShopItemUseCase : AddStorageItemUseCase,
    private val editShopItemUseCase : EditStorageItemListUseCase
) : ViewModel() {


//    private val scope = CoroutineScope(Dispatchers.IO)


    private val _errorInputName = MutableLiveData<Boolean>()
    val errorInputName: LiveData<Boolean>
        get() = _errorInputName

    private val _errorInputCount = MutableLiveData<Boolean>()
    val errorInputCount: LiveData<Boolean>
        get() = _errorInputCount

    private val _storageItem = MutableLiveData<StorageItem>()
    val storageItem: LiveData<StorageItem>
        get() = _storageItem

    private val _shouldCloseScreen = MutableLiveData<Unit>()
    val shouldCloseScreen: LiveData<Unit>
        get() = _shouldCloseScreen

    fun getStorageItem(storageItem: Int) {
        viewModelScope.launch {
            val item = getShopItemUseCase.getStorageItemUseCase(storageItem)
            _storageItem.postValue(item)
        }

    }

    fun addStorageItem(inputName: String?, inputCount: String?) {
        val name = validateName(inputName)
        val count = validateCount(inputCount)
        if (validateInput(name, count)) {
            viewModelScope.launch {
                val storageItem = StorageItem(name = name, count = count)
                addShopItemUseCase.addStorageItemUseCase(storageItem)
                finishWork()
            }
        }
    }

    fun editStorageItem(inputName: String?, inputCount: String?) {
        val name = validateName(inputName)
        val count = validateCount(inputCount)
        if (validateInput(name, count)) {
            viewModelScope.launch {
                _storageItem.value?.let {
                    val item = it.copy(name = name, count = count)
                    editShopItemUseCase.editStorageItemListUseCase(item)
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