package com.example.tech_programming.di

import androidx.lifecycle.ViewModel
import com.example.tech_programming.presentation.shopFragment.requesItemFragment.RequestItemViewModel
import com.example.tech_programming.presentation.shopFragment.requestShopName.RequestShopNameViewModel
import com.example.tech_programming.presentation.shopFragment.shopItemInfoFragment.ShopItemInfoViewModel
import com.example.tech_programming.presentation.shopFragment.shopNameInfoFragment.ShopNameInfoViewModel
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
    @ViewModelKey(ShopItemInfoViewModel::class)
    fun bindShopItemViewModel(viewModel: ShopItemInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopNameInfoViewModel::class)
    fun bindShopNameViewModel(viewModel: ShopNameInfoViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestItemViewModel::class)
    fun bindRequestItemViewModel(viewModel: RequestItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RequestItemViewModel::class)
    fun bindRequestShopNameViewModel(viewModel: RequestShopNameViewModel): ViewModel
}