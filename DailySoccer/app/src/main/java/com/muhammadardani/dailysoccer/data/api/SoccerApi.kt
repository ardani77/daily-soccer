package com.muhammadardani.dailysoccer.data.api

import com.muhammadardani.dailysoccer.data.response.League
import com.muhammadardani.dailysoccer.data.response.Match
import com.muhammadardani.dailysoccer.data.response.PremiereLeague
import kotlinx.coroutines.Deferred
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface SoccerApi {
//    @Headers("Content-Type: application/json")
//    @POST("/send-message-topic")
    @GET("competitions?Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getLeague() :Call<League>

    @GET("standings/1204?Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getPremierLeague() :Call<PremiereLeague>

    @GET("matches?match_date=18.12.2021&Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getMatch() :Call<Match>
}