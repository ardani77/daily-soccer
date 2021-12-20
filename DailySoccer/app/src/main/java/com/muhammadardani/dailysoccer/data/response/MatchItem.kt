package com.muhammadardani.dailysoccer.data.response

data class MatchItem(
    val comp_id: String,
    val et_score: Any,
//    val events: List<Event>,
    val formatted_date: String,
    val ft_score: String,
    val ht_score: String,
    val id: String,
    val localteam_id: String,
    val localteam_name: String,
    val localteam_score: String,
    val penalty_local: Any,
    val penalty_visitor: Any,
    val season: String,
    val status: String,
    val time: String,
    val timer: Any,
    val venue: String,
    val venue_city: String,
    val venue_id: String,
    val visitorteam_id: String,
    val visitorteam_name: String,
    val visitorteam_score: String,
    val week: String
)