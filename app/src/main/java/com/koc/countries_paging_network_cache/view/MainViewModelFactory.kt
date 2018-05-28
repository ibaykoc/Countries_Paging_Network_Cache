package com.koc.countries_paging_network_cache.view

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.koc.countries_paging_network_cache.model.CountriesRepo

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(val countriesRepo: CountriesRepo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(countriesRepo) as T
    }
}