package com.example.ted_rss_feed

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getItems(@Url url: String): Call<GitResponse>
}