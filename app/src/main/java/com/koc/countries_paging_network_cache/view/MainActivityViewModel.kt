package com.koc.countries_paging_network_cache.view

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel
import android.arch.paging.PagedList
import com.koc.countries_paging_network_cache.model.CountriesRepo
import com.koc.countries_paging_network_cache.model.CountryValid
import com.koc.countries_paging_network_cache.model.RepoResult

class MainActivityViewModel(private val countriesRepo: CountriesRepo):ViewModel() {

    val countryGetResult = MutableLiveData<RepoResult<PagedList<CountryValid>>>()

    val data = Transformations.switchMap(countryGetResult) {
        it.data
    }

    val loading = Transformations.switchMap(countryGetResult) {
        it.loading
    }

    val error = Transformations.switchMap(countryGetResult) {
        it.networkError
    }

    fun loadData() {
        countryGetResult.value = countriesRepo.getData()
    }
}