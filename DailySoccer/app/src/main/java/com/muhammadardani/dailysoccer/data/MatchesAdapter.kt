package com.muhammadardani.dailysoccer.data

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import com.muhammadardani.dailysoccer.R
import com.muhammadardani.dailysoccer.data.response.Match
import com.muhammadardani.dailysoccer.data.response.MatchItem


class MatchesAdapter(var matchList: Match, var context: Activity) : ArrayAdapter<MatchItem>(context, R.layout.item_match, matchList) {
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

        //tv_num.text = (position+1).toString()+"."
        val konten = matchList.get(position)
//        Picasso.get().load(konten.sampul).into(sampul);
        jam_pertandingan.text = konten.time
        home_teamname.text = konten.localteam_name
        home_teamscore.text = konten.localteam_score
        visitor_teamscore.text = konten.visitorteam_score
        visitor_teamname.text = konten.visitorteam_name

        return view
    }

}