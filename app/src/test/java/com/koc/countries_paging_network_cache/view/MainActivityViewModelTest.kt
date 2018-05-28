package com.koc.countries_paging_network_cache.view

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PagedList
import com.koc.countries_paging_network_cache.model.CountriesRepo
import com.koc.countries_paging_network_cache.model.CountryValid
import com.koc.countries_paging_network_cache.model.RepoResult
import com.koc.countries_paging_network_cache.util.LiveDataTestUtil
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MainActivityViewModelTest {


    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        RxJavaPlugins.setIoSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setComputationSchedulerHandler { Schedulers.trampoline() }
        RxJavaPlugins.setNewThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
    }

    @Test
    fun whenLoadDataCalled_shouldCallRepoGetData() {
        // Given
        val countryRepo = Mockito.mock(CountriesRepo::class.java)
        val mainActivityViewModel = MainActivityViewModel(countryRepo)

        // When
        mainActivityViewModel.loadData()

        // Then
        Mockito.verify(countryRepo).getData()
    }

    @Suppress("UNCHECKED_CAST")
    @Test
    fun whenGetData_shouldUpdatedAllVariables() {
        // Given
        val countryRepo = Mockito.mock(CountriesRepo::class.java)
        val mainActivityViewModel = MainActivityViewModel(countryRepo)

        val dummyCountryValid = Mockito.mock(PagedList::class.java) as PagedList<CountryValid>
        val dummyCountryValidLiveData = MutableLiveData<PagedList<CountryValid>>()
        dummyCountryValidLiveData.value = dummyCountryValid
        val dummyLoadingLiveData = MutableLiveData<Boolean>().also { it.value = false }
        val dummyNetworkErrorLiveData = MutableLiveData<Boolean>().also { it.value = false }
        val dummyRepoResult = RepoResult<PagedList<CountryValid>>(
                dummyLoadingLiveData,
                dummyNetworkErrorLiveData,
                dummyCountryValidLiveData
        )

        Mockito.`when`(countryRepo.getData()).thenReturn(dummyRepoResult)

        // When
        mainActivityViewModel.loadData()

        // Then
        Assert.assertEquals(
                dummyCountryValidLiveData.value!!,
                LiveDataTestUtil.getValue(mainActivityViewModel.data
                ))
        Assert.assertEquals(
                dummyLoadingLiveData.value!!,
                LiveDataTestUtil.getValue(mainActivityViewModel.loading
                ))
        Assert.assertEquals(
                dummyNetworkErrorLiveData.value!!,
                LiveDataTestUtil.getValue(mainActivityViewModel.error
                ))

    }
}