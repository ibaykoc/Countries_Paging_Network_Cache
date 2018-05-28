package com.koc.countries_paging_network_cache.model

import android.arch.paging.DataSource
import android.util.Log
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CountriesLocalCache_Impl(private val countriesDao: CountriesDao) : CountriesLocalCache {
    val logTag = this::class.java.simpleName

    override fun insertCountries(countries: List<CountryValid>) {
        Single.fromCallable {
            countriesDao.insert(countries)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                }, {

                })
    }

    override fun getAllCountries(): DataSource.Factory<Int, CountryValid> {
        return countriesDao.getAllCountries()
    }

    override fun deleteAll() {
        Single.fromCallable {
            countriesDao.deleteAllContact()
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.d(logTag, "Success delete all")
                }, {
                    Log.d(logTag, "Failed delete all")
                })    }
}