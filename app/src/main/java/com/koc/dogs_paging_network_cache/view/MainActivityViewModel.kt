package com.koc.dogs_paging_network_cache.view

import com.koc.dogs_paging_network_cache.model.DogRepo

class MainActivityViewModel(private val dogRepo:DogRepo) {
    fun loadData() {
        dogRepo.getData()
    }
}