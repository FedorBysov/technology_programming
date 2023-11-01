package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.presentation.requestFragment.RequestShopNameFragment
import com.example.tech_programming.presentation.shopFragment.ShopNameAddFragment
import com.example.tech_programming.presentation.shopFragment.ShopNameListFragment
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

    fun inject(fragment: ShopNameAddFragment)

    fun inject(fragment: RequestShopNameFragment)



}