package com.koc.dogs_paging_network_cache.view

import com.koc.dogs_paging_network_cache.model.DogRepo
import org.junit.Test
import org.mockito.Mockito

class MainActivityViewModelTest {

    private val dogRepo = Mockito.mock(DogRepo::class.java)
    private val mainActivityViewModel = MainActivityViewModel(dogRepo)

    @Test
    fun whenLoadDataCalled_ShouldCallRepoGetData() {
        mainActivityViewModel.loadData()
        Mockito.verify(dogRepo).getData()
    }

}