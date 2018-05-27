package com.koc.dogs_paging_network_cache.model

class DogRepo_Impl(val dogLocalCache: DogLocalCache):DogRepo {
    override fun getData() {
        dogLocalCache.getCache()
    }
}