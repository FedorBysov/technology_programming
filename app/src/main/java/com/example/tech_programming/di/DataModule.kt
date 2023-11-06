package com.example.tech_programming.di

import android.app.Application
import com.example.tech_programming.data.AppDataBase
import com.example.tech_programming.data.db.dao.RequestItemDao
import com.example.tech_programming.data.db.dao.ShopItemDao
import com.example.tech_programming.data.db.dao.ShopNameDao
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.AppImpl
import com.example.tech_programming.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {
    @ApplicationScope
    @Binds
    fun bindRepository(appImpl: AppImpl): Repository



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