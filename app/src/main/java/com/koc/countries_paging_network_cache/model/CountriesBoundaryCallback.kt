package com.koc.countries_paging_network_cache.model

import android.arch.paging.PagedList
import android.util.Log

class CountriesBoundaryCallback(private val contactRepo: CountriesRepo)
    : PagedList.BoundaryCallback<CountryValid>() {

    override fun onZeroItemsLoaded() {
        super.onZeroItemsLoaded()
        Log.d(this::class.java.simpleName, "onZeroItemsLoaded")
        contactRepo.fetchAndSaveData()
    }
}