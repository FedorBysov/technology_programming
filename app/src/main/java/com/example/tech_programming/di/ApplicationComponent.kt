package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.presentation.MainActivity
import com.example.tech_programming.presentation.shopFragment.requesItemFragment.RequestItemFragment
import com.example.tech_programming.presentation.shopFragment.requestShopName.RequestShopNameFragment
import com.example.tech_programming.presentation.shopFragment.shopItemInfoFragment.ShopItemInfoFragment
import com.example.tech_programming.presentation.shopFragment.shopNameInfoFragment.ShopNameInfoFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageItemFragment
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

    fun inject(activity: MainActivity)
    fun inject(fragment: ShopItemInfoFragment)
    fun inject(fragment: ShopNameInfoFragment)
    fun inject(fragment: RequestItemFragment)
    fun inject(fragment: RequestShopNameFragment)
    fun inject(fragment: StorageItemFragment)


}