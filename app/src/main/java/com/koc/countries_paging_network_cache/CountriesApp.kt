package com.koc.countries_paging_network_cache

import android.app.Application
import android.arch.persistence.room.Room
import com.koc.countries_paging_network_cache.model.*
import com.koc.countries_paging_network_cache.view.MainViewModelFactory
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.Module

class CountriesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(contactRepoModule))
    }


    val contactRepoModule: Module = org.koin.dsl.module.applicationContext {
        factory { MainViewModelFactory(get()) }
        bean {
            CountriesRepo_Impl(
                    CountriesLocalCache_Impl(
                            CountriesDatabase.getInstance(this@CountriesApp).countriesDao()
                    ),
                    CountriesApiService.create(),
                    Schedulers.io(),
                    AndroidSchedulers.mainThread()
            ) as CountriesRepo
        }
    }

    val contactRepoTestModule: Module = org.koin.dsl.module.applicationContext {
        bean {
            // In-Memory database config
            Room.inMemoryDatabaseBuilder(get(), CountriesDatabase::class.java)
                    .allowMainThreadQueries()
                    .build()
        }
    }

}