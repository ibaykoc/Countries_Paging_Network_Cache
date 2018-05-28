package com.koc.countries_paging_network_cache.model

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.util.Log
import com.koc.countries_paging_network_cache.util.validate
import io.reactivex.Scheduler

class CountriesRepo_Impl(val countriesLocalCache: CountriesLocalCache,
                         val countriesApiService: CountriesApiService,
                         val bgThread: Scheduler,
                         val uiThread: Scheduler): CountriesRepo {
    private val networkError = MutableLiveData<Boolean>()
    private val networkLoading = MutableLiveData<Boolean>()

    override fun getData(): RepoResult<PagedList<CountryValid>> {
        networkError.value = false
        val data = countriesLocalCache.getAllCountries()
        val builder = LivePagedListBuilder(data, 10)
                .setBoundaryCallback(CountriesBoundaryCallback(this))
        return RepoResult(networkLoading, networkError, builder.build())
    }

    override fun fetchAndSaveData() {
        networkLoading.value?.let{
            if(it) return
        }

        networkLoading.value = true

        countriesApiService.fetchAllCountries()
                .subscribeOn(bgThread)
                .observeOn(uiThread)
                .subscribe({
                    networkLoading.value = false
                    val validContact = it.map {
                        it.validate()
                    }.filter {
                        it != null
                    } as List<CountryValid>

                    countriesLocalCache.insertCountries(validContact)
                }, {
                    networkLoading.value = false
                    networkError.value = true
                })
    }
}