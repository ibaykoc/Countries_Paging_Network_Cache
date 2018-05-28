package com.koc.countries_paging_network_cache.model
import com.google.gson.annotations.SerializedName

data class CountriesResponse(
    @SerializedName("name") val name: String?, //Zimbabwe
    @SerializedName("topLevelDomain") val topLevelDomain: List<String?>?,
    @SerializedName("alpha2Code") val alpha2Code: String?, //ZW
    @SerializedName("alpha3Code") val alpha3Code: String?, //ZWE
    @SerializedName("callingCodes") val callingCodes: List<String?>?,
    @SerializedName("capital") val capital: String?, //Harare
    @SerializedName("altSpellings") val altSpellings: List<String?>?,
    @SerializedName("region") val region: String?, //Africa
    @SerializedName("subregion") val subregion: String?, //Eastern Africa
    @SerializedName("population") val population: Int?, //14240168
    @SerializedName("latlng") val latlng: List<Double?>?,
    @SerializedName("demonym") val demonym: String?, //Zimbabwean
    @SerializedName("area") val area: Double?, //390757.0
    @SerializedName("gini") val gini: Any?, //null
    @SerializedName("timezones") val timezones: List<String?>?,
    @SerializedName("borders") val borders: List<String?>?,
    @SerializedName("nativeName") val nativeName: String?, //Zimbabwe
    @SerializedName("numericCode") val numericCode: String?, //716
    @SerializedName("currencies") val currencies: List<Currency?>?,
    @SerializedName("languages") val languages: List<Language?>?,
    @SerializedName("translations") val translations: Translations?,
    @SerializedName("flag") val flag: String?, //https://restcountries.eu/data/zwe.svg
    @SerializedName("regionalBlocs") val regionalBlocs: List<RegionalBloc?>?,
    @SerializedName("cioc") val cioc: String? //ZIM
) {
    data class RegionalBloc(
        @SerializedName("acronym") val acronym: String?, //AU
        @SerializedName("name") val name: String?, //African Union
        @SerializedName("otherAcronyms") val otherAcronyms: List<Any?>?,
        @SerializedName("otherNames") val otherNames: List<String?>?
    )

    data class Language(
        @SerializedName("iso639_1") val iso6391: String?, //nd
        @SerializedName("iso639_2") val iso6392: String?, //nde
        @SerializedName("name") val name: String?, //Northern Ndebele
        @SerializedName("nativeName") val nativeName: String? //isiNdebele
    )

    data class Currency(
        @SerializedName("code") val code: String?, //(none)
        @SerializedName("name") val name: Any?, //null
        @SerializedName("symbol") val symbol: Any? //null
    )

    data class Translations(
        @SerializedName("de") val de: String?, //Simbabwe
        @SerializedName("es") val es: String?, //Zimbabue
        @SerializedName("fr") val fr: String?, //Zimbabwe
        @SerializedName("ja") val ja: String?, //ジンバブエ
        @SerializedName("it") val it: String?, //Zimbabwe
        @SerializedName("br") val br: String?, //Zimbabwe
        @SerializedName("pt") val pt: String?, //Zimbabué
        @SerializedName("nl") val nl: String?, //Zimbabwe
        @SerializedName("hr") val hr: String?, //Zimbabve
        @SerializedName("fa") val fa: String? //زیمباوه
    )
}