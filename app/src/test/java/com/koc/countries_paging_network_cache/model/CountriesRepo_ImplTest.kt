package com.koc.countries_paging_network_cache.model

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CountriesRepo_ImplTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun whenGetDataCalled_shouldCallCacheGetAllCountries() {
        // Given
        val countriesLocalCache = Mockito.mock(CountriesLocalCache::class.java)
        val countriesApiService = Mockito.mock(CountriesApiService::class.java)
        val countriesRepo_Impl = CountriesRepo_Impl(
                countriesLocalCache,
                countriesApiService,
                Schedulers.io(),
                Schedulers.io()
        )
        val dummyCacheResponse = Mockito.mock(
                DataSource.Factory::class.java) as DataSource.Factory<Int, CountryValid>
        Mockito.`when`(countriesLocalCache.getAllCountries()).thenReturn(dummyCacheResponse)

        // When
        countriesRepo_Impl.getData()

        //Then
        Mockito.verify(countriesLocalCache).getAllCountries()
    }

}
