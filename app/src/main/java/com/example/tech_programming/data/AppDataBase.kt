package com.example.tech_programming.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tech_programming.data.db.dao.RequestItemDao
import com.example.tech_programming.data.db.dao.ShopItemDao
import com.example.tech_programming.data.db.dao.ShopNameDao
import com.example.tech_programming.data.db.dao.StorageItemDao
import com.example.tech_programming.data.db.model.RequestItemDbModel
import com.example.tech_programming.data.db.model.ShopItemDbModel
import com.example.tech_programming.data.db.model.ShopNameDbModel
import com.example.tech_programming.data.db.model.StorageItemDbModel

@Database(
    entities = [ShopItemDbModel::class, ShopNameDbModel::class, StorageItemDbModel::class, RequestItemDbModel::class],
    version = 2,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {


    abstract fun shopNameDao(): ShopNameDao
    abstract fun shopItemDao(): ShopItemDao
    abstract fun storageItemDao(): StorageItemDao
    abstract fun requestItemDao(): RequestItemDao


    companion object {

        private var INSTANCE: AppDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "shop_item.db"

        fun getInstance(application: Application): AppDataBase {
            INSTANCE?.let {
                return it
            }
            synchronized(LOCK) {
                INSTANCE?.let {
                    return it
                }
            }
            val db = Room.databaseBuilder(
                application,
                AppDataBase::class.java,
                DB_NAME
            )
//                .allowMainThreadQueries()
                .build()
            INSTANCE = db
            return db
        }
    }
}