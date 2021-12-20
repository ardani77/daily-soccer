package com.muhammadardani.dailysoccer.data

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.muhammadardani.dailysoccer.R
import com.muhammadardani.dailysoccer.data.response.Match
import com.muhammadardani.dailysoccer.data.response.MatchItem


class MatchesAdapter(var matchList: List<MatchItem>, var context: Activity) : ArrayAdapter<MatchItem>(context, R.layout.item_match, matchList) {
//    override fun getItem(position: Int): Any {
//        return standingList.get(position)
//    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return matchList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //val view: View = View.inflate(context ,R.layout.item_card,null)
        val layoutInflayer : LayoutInflater = LayoutInflater.from(context)
        val view : View = layoutInflayer.inflate(R.layout.item_match, null)
        val jam_pertandingan = view.findViewById<TextView>(R.id.time) as TextView
        val home_teamname = view.findViewById<TextView>(R.id.localteam) as TextView
        val home_teamscore = view.findViewById<TextView>(R.id.localteamscore) as TextView
        val visitor_teamname = view.findViewById<TextView>(R.id.visitorteam) as TextView
        val visitor_teamscore = view.findViewById<TextView>(R.id.visitorteamscore) as TextView
        val leagueCode = view.findViewById<TextView>(R.id.compId) as TextView
        val nameCountry = view.findViewById<TextView>(R.id.countryName) as TextView
        val imageCountry = view.findViewById<ImageView>(R.id.flagView) as ImageView

        //tv_num.text = (position+1).toString()+"."
        val konten = matchList.get(position)
//        Picasso.get().load(konten.sampul).into(sampul);
        jam_pertandingan.text = konten.time
        home_teamname.text = konten.localteam_name
        home_teamscore.text = konten.localteam_score
        visitor_teamscore.text = konten.visitorteam_score
        visitor_teamname.text = konten.visitorteam_name
        leagueCode.text = konten.comp_id

        leagueCode.text = when(leagueCode.text){
            "1093" -> "Austrian Football Bundesliga"
            "1102" -> "Belgium UEFA Europa League Play-Offs"
            "1184" -> "Czech First League"
            "1205" -> "English Football League Championship"
            "1204" -> "English Premier League"
            "1199" -> "Not Found"
            "1198" -> "Not Found"
            "1007" -> "UEFA Europa League"
            "1005" -> "UEFA Champions League"
            "1221" -> "League 1"
            "1229" -> "Bundesliga"
            "1232" -> "Super League Greece 1"
            "1322" -> "Eredivisie"
            "1269" -> "Serie A"
            "1265" -> "Serie B"
            "1352" -> "Primeira Liga"
            "1457" -> "Russian Premier League"
            "1399" -> "La Liga"
            "1397" -> "Not found"
            "1408" -> "Swiss Super League"
            "1425" -> "Süper Lig"
            "1428" -> "Ukrainian Premier League"
            else -> ({}).toString()
        }

        nameCountry.text = when(leagueCode.text){
            "Austrian Football Bundesliga" -> "Austria"
            "Belgium UEFA Europa League Play-Offs" -> "Belgium"
            "Czech First League" -> "Czech Republic"
            "English Football League Championship" -> "England"
            "English Premier League" -> "England"
            "Not Found" -> "Not Found"
            "Not Found" -> "Not Found"
            "UEFA Europa League" -> "Europe"
            "UEFA Champions League" -> "Europe"
            "League 1" -> "France"
            "Bundesliga" -> "Germany"
            "Super League Greece 1" -> "Greece"
            "Eredivisie" -> "Netherland"
            "Serie A" -> "Italy"
            "Serie B" -> "Italy"
            "Primeira Liga" -> "Portugal"
            "Russian Premier League" -> "Rusia"
            "La Liga" -> "Spain"
            "Not Found" -> "Not found"
            "Swiss Super League" -> "Switzerland"
            "Süper Lig" -> "Turkey"
            "Ukrainian Premier League" -> "Ukraine"
            else -> ({}).toString()
        }

        if (leagueCode.text == "Austrian Football Bundesliga"){
            imageCountry.setImageResource(R.drawable.flag_austria)
        }
        if (leagueCode.text == "Belgium UEFA Europa League Play-Offs"){
            imageCountry.setImageResource(R.drawable.flag_belgium)
        }
        if (leagueCode.text == "Czech First League"){
            imageCountry.setImageResource(R.drawable.flag_czech_republic)
        }
        if (leagueCode.text == "English Football League Championship"){
            imageCountry.setImageResource(R.drawable.flag_england)
        }
        if (leagueCode.text == "English Premier League"){
            imageCountry.setImageResource(R.drawable.flag_england)
        }
        if (leagueCode.text == "UEFA Europa League"){
            imageCountry.setImageResource(R.drawable.ic_europa_league)
        }
        if (leagueCode.text == "UEFA Champions League"){
            imageCountry.setImageResource(R.drawable.ic_uefa_champions_league_logo_2)
        }
        if (leagueCode.text == "League 1"){
            imageCountry.setImageResource(R.drawable.flag_austria)
        }
        if (leagueCode.text == "Bundesliga"){
            imageCountry.setImageResource(R.drawable.flag_germany)
        }
        if (leagueCode.text == "Super League Greece 1"){
            imageCountry.setImageResource(R.drawable.flag_greece)
        }
        if (leagueCode.text == "Eredivisie"){
            imageCountry.setImageResource(R.drawable.flag_netherlands)
        }
        if (leagueCode.text == "Serie A"){
            imageCountry.setImageResource(R.drawable.flag_italy)
        }
        if (leagueCode.text == "Serie B"){
            imageCountry.setImageResource(R.drawable.flag_italy)
        }
        if (leagueCode.text == "Primeira Liga"){
            imageCountry.setImageResource(R.drawable.flag_portugal)
        }
        if (leagueCode.text == "Russian Premier League"){
            imageCountry.setImageResource(R.drawable.flag_russia)
        }
        if (leagueCode.text == "La Liga"){
            imageCountry.setImageResource(R.drawable.flag_spain)
        }
        if (leagueCode.text == "Swiss Super League"){
            imageCountry.setImageResource(R.drawable.flag_switzerland)
        }
        if (leagueCode.text == "Süper Lig"){
            imageCountry.setImageResource(R.drawable.flag_turkey)
        }
        if (leagueCode.text == "Ukrainian Premier League"){
            imageCountry.setImageResource(R.drawable.flag_ukraine)
        }










        return view
    }

}