package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.presentation.MainActivity
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddActivity
import com.example.tech_programming.presentation.storageItemFragment.StorageEditAddFragment
import com.example.tech_programming.presentation.storageItemFragment.StorageItemListActivity
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

    fun inject(activity: StorageItemListActivity)
    fun inject(fragment: StorageEditAddFragment)



}