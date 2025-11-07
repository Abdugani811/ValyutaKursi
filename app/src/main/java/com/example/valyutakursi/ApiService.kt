package com.example.valyutakursi

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("uz/arkhiv-kursov-valyut/json/")
    suspend fun getCurrency(): Call<List<CurrencyRate>>
}