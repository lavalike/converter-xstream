package com.tcl.tikxml_samples.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET
    fun mobileInfo(@Url url: String): Call<String>
}