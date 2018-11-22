package com.jmasagi.uptdjabar2.core

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.jmasagi.uptdjabar2.core.Constant.DBNAME
import com.jmasagi.uptdjabar2.data.dao.DaoInspectors
import com.jmasagi.uptdjabar2.data.entity.ModelInspectors

@Database(
    entities = arrayOf(
        ModelInspectors.Data::class
    ),
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoInspectors(): DaoInspectors

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java, DBNAME
                    ).build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

}