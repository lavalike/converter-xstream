package com.tcl.tikxml_samples.api

import com.tcl.tikxml_samples.entity.RandomFontsResp
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET
    fun mobileInfo(@Url url: String): Call<String>

    @FormUrlEncoded
    @POST
    fun traditionalChinese(@Url url: String, @Field("sText") city: String): Call<String>

    @FormUrlEncoded
    @POST
    fun randomChineseFonts(
        @Url url: String,
        @Field("byFontsLength") length: Int
    ): Call<RandomFontsResp>
}