package com.koc.dogs_paging_network_cache.model

import org.junit.Test
import org.mockito.Mockito

class DogRepo_ImplTest {

    private val dogApiService = Mockito.mock(DogLocalCache::class.java)
    private val dogRepo_Impl = DogRepo_Impl(dogApiService)

    @Test
    fun whenGetDataCalled_shouldCallCacheGetCache() {
        dogRepo_Impl.getData()

        Mockito.verify(dogApiService).getCache()
    }

}