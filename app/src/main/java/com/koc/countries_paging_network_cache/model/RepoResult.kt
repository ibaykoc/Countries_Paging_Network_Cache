package com.koc.countries_paging_network_cache.model

import android.arch.lifecycle.LiveData

data class RepoResult<T>(
        val loading: LiveData<Boolean>,
        val networkError: LiveData<Boolean>,
        val data: LiveData<T>
)