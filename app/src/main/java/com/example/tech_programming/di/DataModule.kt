package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.data.AppDataBase
import com.example.tech_programming.data.db.dao.RequestItemDao
import com.example.tech_programming.data.db.dao.ShopItemDao
import com.example.tech_programming.data.db.dao.ShopNameDao
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.impl.RequestItemImpl
import com.example.tech_programming.data.impl.ShopItemImpl
import com.example.tech_programming.data.impl.ShopNameImpl
import com.example.tech_programming.data.impl.StorageItemImpl
import com.example.tech_programming.domain.repository.RequestItemRepository
import com.example.tech_programming.domain.repository.ShopItemRepository
import com.example.tech_programming.domain.repository.ShopNameRepository
import com.example.tech_programming.domain.repository.StorageItemRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindRequestItemRepository(impl: RequestItemImpl): RequestItemRepository

    @ApplicationScope
    @Binds
    fun bindShopItemRepository(impl: ShopItemImpl): ShopItemRepository

    @ApplicationScope
    @Binds
    fun bindShopNameRepository(impl: ShopNameImpl): ShopNameRepository

    @ApplicationScope
    @Binds
    fun bindStorageItemRepository(impl: StorageItemImpl): StorageItemRepository


    companion object{

        @ApplicationScope
        @Provides
        fun provideStorageItemDao(
            application: Application
        ): StorageItemDao {
            return AppDataBase.getInstance(application).storageItemDao()
        }

        @ApplicationScope
        @Provides
        fun provideShopNameDao(
            application: Application
        ): ShopNameDao {
            return AppDataBase.getInstance(application).shopNameDao()
        }

        @ApplicationScope
        @Provides
        fun provideShopItemDao(
            application: Application
        ): ShopItemDao {
            return AppDataBase.getInstance(application).shopItemDao()
        }

        @ApplicationScope
        @Provides
        fun provideRequestItemDao(
            application: Application
        ): RequestItemDao {
            return AppDataBase.getInstance(application).requestItemDao()
        }
    }

}