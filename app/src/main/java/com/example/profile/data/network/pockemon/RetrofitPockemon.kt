package com.example.profile.data.network.pockemon

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitPockemon {
    fun api(): ApiServicePockemon {
        val retrofit: Retrofit.Builder by lazy {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            val okhttpClient = OkHttpClient.Builder()
            okhttpClient.addInterceptor(interceptor)
            /*
            * configuracion necesaria para retrofit
            * .base url
            * .client
            * */
            Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .client(okhttpClient.build())
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        }
        return retrofit
            .build()
            .create(ApiServicePockemon::class.java)
    }
}
