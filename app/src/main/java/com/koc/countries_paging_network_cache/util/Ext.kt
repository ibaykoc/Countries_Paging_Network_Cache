package com.koc.countries_paging_network_cache.util

import com.koc.countries_paging_network_cache.model.CountriesResponse
import com.koc.countries_paging_network_cache.model.CountryValid

fun CountriesResponse.validate() : CountryValid?{
    name?.let{
        val name = it
        return CountryValid(name)
    }
    return null
}