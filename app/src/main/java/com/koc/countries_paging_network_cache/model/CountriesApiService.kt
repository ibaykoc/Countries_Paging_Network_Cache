package com.koc.countries_paging_network_cache.model

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CountriesApiService {
    @GET("all")
    fun fetchAllCountries() : Single<List<CountriesResponse>>

    companion object {
        private const val BASE_URL = "https://restcountries.eu/rest/v2/"

        fun create(): CountriesApiService {
            val l = HttpLoggingInterceptor()

            l.setLevel (HttpLoggingInterceptor.Level.BODY);

            val httpClient = OkHttpClient.Builder()
            // add your other interceptors …

            // add logging as last interceptor
            httpClient.addInterceptor(l)

            return  Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build() )
                    .build()
                    .create<CountriesApiService>(CountriesApiService::class.java)
        }
    }
}