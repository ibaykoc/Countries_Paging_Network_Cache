package com.koc.countries_paging_network_cache.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Countries")
data class CountryValid (
        @PrimaryKey @field:SerializedName("name") val name:String
)