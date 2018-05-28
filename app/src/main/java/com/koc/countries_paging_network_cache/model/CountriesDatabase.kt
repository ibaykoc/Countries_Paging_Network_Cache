package com.koc.countries_paging_network_cache.model

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [CountryValid::class], version = 1)
abstract class CountriesDatabase : RoomDatabase() {

    abstract fun countriesDao() : CountriesDao

    companion object {
        @Volatile
        private var INSTANCE: CountriesDatabase? = null

        fun getInstance(context: Context): CountriesDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE
                            ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context.applicationContext,
                        CountriesDatabase::class.java, "Contacts.db")
                        .fallbackToDestructiveMigration()
                        .build()
    }

}