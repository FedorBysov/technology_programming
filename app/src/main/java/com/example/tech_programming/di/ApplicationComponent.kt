package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.presentation.MainActivity
import com.example.tech_programming.presentation.shopFragment.requestFragment.RequestItemFragment
import com.example.tech_programming.presentation.shopFragment.shopItemFragment.ShopItemFragment
import com.example.tech_programming.presentation.shopFragment.shopNameFragment.ShopNameFragment
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
    fun inject(fragment: ShopItemFragment)
    fun inject(fragment: ShopNameFragment)
    fun inject(fragment: RequestItemFragment)
    fun inject(fragment: StorageItemFragment)

}