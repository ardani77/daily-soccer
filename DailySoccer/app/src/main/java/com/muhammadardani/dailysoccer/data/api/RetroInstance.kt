package com.muhammadardani.dailysoccer.data.api

import com.muhammadardani.dailysoccer.data.utils.Constants.Companion.BASE_URL
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroInstance {
    fun getInstance ():Retrofit{
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}