package com.koc.countries_paging_network_cache.model

import android.arch.paging.DataSource

interface CountriesLocalCache {
    fun getAllCountries(): DataSource.Factory<Int, CountryValid>
    fun insertCountries(countries: List<CountryValid>)
    fun deleteAll()
}