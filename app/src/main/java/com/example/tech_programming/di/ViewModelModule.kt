package com.example.tech_programming.di

import androidx.lifecycle.ViewModel
import com.example.tech_programming.presentation.shopFragment.ShopNameAddViewModel
import com.example.tech_programming.presentation.shopFragment.ShopNameListViewModel
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddViewModel
import com.example.tech_programming.presentation.storageItemFragment.StorageItemListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(StorageItemListViewModel::class)
    fun bindStorageItemListViewModel(viewModel: StorageItemListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(StorageEditAddViewModel::class)
    fun bindStorageEditAddViewModel(viewModel: StorageEditAddViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopNameListViewModel::class)
    fun bindShopNameListViewModel(viewModel: ShopNameListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ShopNameAddViewModel::class)
    fun bindShopNameAddViewModel(viewModel: ShopNameAddViewModel): ViewModel

}