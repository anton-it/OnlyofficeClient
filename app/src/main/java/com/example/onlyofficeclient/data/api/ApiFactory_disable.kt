package com.example.onlyofficeclient.data.api

import com.example.onlyofficeclient.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory_disable {
    val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    val client = OkHttpClient.Builder().addInterceptor(interceptor).build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL).client(client)
        .addConverterFactory(GsonConverterFactory.create()).build()

    val apiService = retrofit.create(ApiService::class.java)
}