package com.example.ted_rss_feed

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ServiceBuilder {
    private val client = OkHttpClient.Builder().build()

    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://raw.githubusercontent.com/rolling-scopes-school/rs.android.task.6/master/data/data.json/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build()

    fun<T> buildService(service: Class<T>): T{
        return retrofit.create(service)
    }
}