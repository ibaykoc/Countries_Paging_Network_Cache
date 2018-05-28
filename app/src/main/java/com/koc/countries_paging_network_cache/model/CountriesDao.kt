package com.koc.countries_paging_network_cache.model

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query

@Dao
interface CountriesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(contacts: List<CountryValid>)

    @Query(" SELECT * FROM Countries ORDER BY name asc")
    fun getAllCountries() : DataSource.Factory<Int, CountryValid>

    @Query("DELETE FROM Countries")
    fun deleteAllContact()
}