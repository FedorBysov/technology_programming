package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.presentation.requestFragment.AllRequestShopNameFragment
import com.example.tech_programming.presentation.requestFragment.needRequestList.NeedAddEditRequestFragment
import com.example.tech_programming.presentation.requestFragment.needRequestList.NeedListRequestFragment
import com.example.tech_programming.presentation.shopNameFragment.ShopNameAddEditFragment
import com.example.tech_programming.presentation.shopNameFragment.ShopNameListFragment
import com.example.tech_programming.presentation.shopItemFragment.NeedAddEditShopItemFragment
import com.example.tech_programming.presentation.shopItemFragment.NeedListShopItemFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageItemListFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [DataModule::class, ViewModelModule::class]
)
interface ApplicationComponent {

    @Component.Factory
    interface Factory{

        fun create(
            @BindsInstance application: Application
        ):ApplicationComponent
    }

    fun inject(fragment: StorageItemListFragment)

    fun inject(fragment: StorageEditAddFragment)

    fun inject(fragment: ShopNameListFragment)

    fun inject(fragment: ShopNameAddEditFragment)

    fun inject(fragment: AllRequestShopNameFragment)

    fun inject(fragment: NeedListRequestFragment)

    fun inject(fragment: NeedAddEditRequestFragment)

    fun inject(fragment: NeedAddEditShopItemFragment)

    fun inject(fragment: NeedListShopItemFragment)



}