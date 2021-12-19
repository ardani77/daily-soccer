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
import com.muhammadardani.dailysoccer.data.response.PremiereLeague
import com.muhammadardani.dailysoccer.data.response.PremiereLeagueItem


class LeagueAdapter(var standingList: PremiereLeague, var context: Activity) : ArrayAdapter<PremiereLeagueItem>(context, R.layout.item_league, standingList) {
//    override fun getItem(position: Int): Any {
//        return standingList.get(position)
//    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return standingList.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        //val view: View = View.inflate(context ,R.layout.item_card,null)
        val layoutInflayer : LayoutInflater = LayoutInflater.from(context)
        val view : View = layoutInflayer.inflate(R.layout.item_league, null)
        val posisi = view.findViewById<TextView>(R.id.placement) as TextView
        val name_team = view.findViewById<TextView>(R.id.nameteam) as TextView
        val jumlah_pertandingan = view.findViewById<TextView>(R.id.match) as TextView
        val total_kemenangan = view.findViewById<TextView>(R.id.win) as TextView
        val total_seri = view.findViewById<TextView>(R.id.draw) as TextView
        val total_kekalahan = view.findViewById<TextView>(R.id.lose) as TextView
        val selisih_goal = view.findViewById<TextView>(R.id.gf_ga) as TextView
        val total_poin = view.findViewById<TextView>(R.id.point) as TextView

        //tv_num.text = (position+1).toString()+"."
        val konten = standingList.get(position)
//        Picasso.get().load(konten.sampul).into(sampul);
        posisi.text = konten.position
        name_team.text = konten.team_name
        jumlah_pertandingan.text = konten.round
        total_kemenangan.text = konten.overall_w
        total_seri.text = konten.overall_d
        total_kekalahan.text = konten.overall_l
        selisih_goal.text = konten.overall_gs + "-" + konten.overall_ga
        total_poin.text = konten.points

        return view
    }

}