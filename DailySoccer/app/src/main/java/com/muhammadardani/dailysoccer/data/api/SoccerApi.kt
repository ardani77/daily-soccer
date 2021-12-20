package com.muhammadardani.dailysoccer.data.api

import com.muhammadardani.dailysoccer.data.response.League
import com.muhammadardani.dailysoccer.data.response.Match
import com.muhammadardani.dailysoccer.data.response.PremiereLeague
import com.muhammadardani.dailysoccer.data.response.StandingsLeague
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SoccerApi {
//    @Headers("Content-Type: application/json")
//    @POST("/send-message-topic")
    @GET("competitions?Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getLeague() :Call<League>

    @GET("standings/1204?Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
//    @GET("standings/"+codeLeague+"?Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getPremierLeague() :Call<StandingsLeague>

    @GET("standings/{codeLeague}?Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getStandingsLeague(@Path(value = "codeLeague") leagueCode: String) :Call<StandingsLeague>

//    @GET("matches?match_date=19.12.2021&Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
//    fun getMatch() :Call<Match>

    @GET("matches?match_date=dateMatch&Authorization=cfnR6LWc4i4MDFLlPJrajoa465c4qjF594kpIy4b")
    fun getMatchToday(@Query("match_date") dateMatch: String) :Call<Match>
}