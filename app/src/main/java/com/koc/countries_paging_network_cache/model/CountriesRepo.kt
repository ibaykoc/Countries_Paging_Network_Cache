package com.koc.countries_paging_network_cache.model

import android.arch.lifecycle.LiveData
import android.arch.paging.PagedList

interface CountriesRepo {
    fun getData() : RepoResult<PagedList<CountryValid>>
    fun fetchAndSaveData()
}