package com.example.tech_programming.di

import androidx.lifecycle.ViewModel
import com.example.tech_programming.presentation.shopFragment.requestFragment.RequestItemViewModel
import com.example.tech_programming.presentation.shopFragment.shopItemFragment.ShopItemViewModel
import com.example.tech_programming.presentation.shopFragment.shopNameFragment.ShopNameViewModel
import com.example.tech_programming.presentation.storageItemFragment.StorageItemViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StorageItemViewModel::class)
    fun bindStorageItemViewModel(viewModel: StorageItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopItemViewModel::class)
    fun bindShopItemViewModel(viewModel: ShopItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopNameViewModel::class)
    fun bindShopNameViewModel(viewModel: ShopNameViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestItemViewModel::class)
    fun bindRequestItemViewModel(viewModel: RequestItemViewModel): ViewModel
}