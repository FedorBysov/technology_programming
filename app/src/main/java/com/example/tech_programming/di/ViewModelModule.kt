package com.example.tech_programming.di

import androidx.lifecycle.ViewModel
import com.example.tech_programming.presentation.requestFragment.needRequestList.NeedAddEditRequestViewModel
import com.example.tech_programming.presentation.requestFragment.needRequestList.NeedListRequestViewModel
import com.example.tech_programming.presentation.shopNameFragment.ShopNameAddEditViewModel
import com.example.tech_programming.presentation.shopNameFragment.ShopNameListViewModel
import com.example.tech_programming.presentation.shopItemFragment.NeedAddEditShopItemViewModel
import com.example.tech_programming.presentation.shopItemFragment.NeedListShopItemViewModel
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
    @ViewModelKey(ShopNameAddEditViewModel::class)
    fun bindShopNameAddEditViewModel(viewModel: ShopNameAddEditViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NeedAddEditRequestViewModel::class)
    fun bindNeedAddEditRequestViewModel(viewModel: NeedAddEditRequestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NeedListRequestViewModel::class)
    fun bindNeedListRequestViewModel(viewModel: NeedListRequestViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NeedAddEditShopItemViewModel::class)
    fun bindNeedAddEditShopItemViewModel(viewModel: NeedAddEditShopItemViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(NeedListShopItemViewModel::class)
    fun bindNeedListShopItemViewModel(viewModel: NeedListShopItemViewModel): ViewModel
}