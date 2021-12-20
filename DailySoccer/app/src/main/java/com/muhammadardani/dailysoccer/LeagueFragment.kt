package com.muhammadardani.dailysoccer

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.muhammadardani.dailysoccer.data.LeagueAdapter
import com.muhammadardani.dailysoccer.data.api.RetroInstance
import com.muhammadardani.dailysoccer.data.api.SoccerApi
import com.muhammadardani.dailysoccer.data.response.PremiereLeague
import com.muhammadardani.dailysoccer.data.response.StandingsLeague
import kotlinx.android.synthetic.main.fragment_league.*
import kotlinx.android.synthetic.main.fragment_league.view.*
import kotlinx.android.synthetic.main.item_match.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LeagueFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LeagueFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var liga : TextView
    lateinit var list_standing: ListView   //list view
    lateinit var countryImage: ImageView
    lateinit var leagueImage: ImageView
    lateinit var teamStandingsTitle: TextView
    lateinit var countryNameStandings: TextView
    lateinit var pemisah3: TextView
    lateinit var leagueNameStandings: TextView
    lateinit var peringkat: TextView
    lateinit var namaTim: TextView
    lateinit var pertandingan: TextView
    lateinit var menang: TextView
    lateinit var seri: TextView
    lateinit var kalah: TextView
    lateinit var selisihGol: TextView
    lateinit var placementPoin: TextView

    lateinit var adapter: com.muhammadardani.dailysoccer.data.LeagueAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_league, container, false)
        countryImage = view.countryImage
        leagueImage = view.leagueImage
        teamStandingsTitle = view.teamStandingsTitle
        countryNameStandings = view.countryNameStandings
        pemisah3 = view.pemisah3
        leagueNameStandings = view.leagueNameStandings
        peringkat = view.peringkat
        namaTim = view.namaTim
        pertandingan = view.pertandingan
        menang = view.menang
        seri = view.seri
        kalah = view.kalah
        selisihGol = view.selisihGol
        placementPoin = view.placementPoin

        list_standing = view.standingList
        // access the items of the list
        val languages = resources.getStringArray(R.array.Languages)

        // access the spinner
        val spinner = view.findViewById<Spinner>(R.id.spinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(requireContext(),
                android.R.layout.simple_spinner_item, languages)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(requireContext(),
                        getString(R.string.selected_item) + " " +
                                "" + languages[position], Toast.LENGTH_SHORT).show()
                    val kodeliga_nama = languages[position].toString()
                    val kodeliga_angka = when(kodeliga_nama){
                        "Austrian Football Bundesliga" -> "1093"
                        "Belgium UEFA Europa League Play-Offs" -> "1102"
                        "Czech First League" -> "1184"
                        "English Football League Championship" -> "1205"
                        "English Premier League" -> "1204"
                        "UEFA Europa League" -> "1007"
                        "UEFA Champions League" -> "1005"
                        "League 1" -> "1221"
                        "Bundesliga" -> "1229"
                        "Super League Greece 1" -> "1232"
                        "Eredivisie" -> "1322"
                        "Serie A" -> "1269"
                        "Serie B" -> "1265"
                        "Primeira Liga" -> "1352"
                        "Russian Premier League" -> "1457"
                        "La Liga" -> "1399"
                        "Swiss Super League" ->"1408"
                        "Süper Lig" ->"1425"
                        "Ukrainian Premier League" -> "1428"
                        else -> ({}).toString()
                    }
                    val retro = RetroInstance().getInstance().create(SoccerApi::class.java)
                    retro.getStandingsLeague(kodeliga_angka).enqueue(object : Callback<StandingsLeague> {
                        override fun onResponse(call: Call<StandingsLeague>, response: Response<StandingsLeague>) {
                            val responseBody = response.body()
                            val adapter2 = LeagueAdapter(responseBody!!, activity!!)
                            list_standing.adapter = adapter2
                            countryNameStandings.text = responseBody[0].country
                            leagueNameStandings.text = kodeliga_nama

                            if (leagueNameStandings.text == "Austrian Football Bundesliga"){
                                countryImage.setImageResource(R.drawable.flag_austria)
                            }
                            if (leagueNameStandings.text == "Belgium UEFA Europa League Play-Offs"){
                                countryImage.setImageResource(R.drawable.flag_belgium)
                            }
                            if (leagueNameStandings.text == "Czech First League"){
                                countryImage.setImageResource(R.drawable.flag_czech_republic)
                            }
                            if (leagueNameStandings.text == "English Football League Championship"){
                                countryImage.setImageResource(R.drawable.flag_england)
                            }
                            if (leagueNameStandings.text == "English Premier League"){
                                countryImage.setImageResource(R.drawable.flag_england)
                            }
                            if (leagueNameStandings.text == "UEFA Europa League"){
                                countryImage.setImageResource(R.drawable.ic_europa_league)
                            }
                            if (leagueNameStandings.text == "UEFA Champions League"){
                                countryImage.setImageResource(R.drawable.ic_uefa_champions_league_logo_2)
                            }
                            if (leagueNameStandings.text == "League 1"){
                                countryImage.setImageResource(R.drawable.flag_france)
                            }
                            if (leagueNameStandings.text == "Bundesliga"){
                                countryImage.setImageResource(R.drawable.flag_germany)
                            }
                            if (leagueNameStandings.text == "Super League Greece 1"){
                                countryImage.setImageResource(R.drawable.flag_greece)
                            }
                            if (leagueNameStandings.text == "Eredivisie"){
                                countryImage.setImageResource(R.drawable.flag_netherlands)
                            }
                            if (leagueNameStandings.text == "Serie A"){
                                countryImage.setImageResource(R.drawable.flag_italy)
                            }
                            if (leagueNameStandings.text == "Serie B"){
                                countryImage.setImageResource(R.drawable.flag_italy)
                            }
                            if (leagueNameStandings.text == "Primeira Liga"){
                                countryImage.setImageResource(R.drawable.flag_portugal)
                            }
                            if (leagueNameStandings.text == "Russian Premier League"){
                                countryImage.setImageResource(R.drawable.flag_russia)
                            }
                            if (leagueNameStandings.text == "La Liga"){
                                countryImage.setImageResource(R.drawable.flag_spain)
                            }
                            if (leagueNameStandings.text == "Swiss Super League"){
                                countryImage.setImageResource(R.drawable.flag_switzerland)
                            }
                            if (leagueNameStandings.text == "Süper Lig"){
                                countryImage.setImageResource(R.drawable.flag_turkey)
                            }
                            if (leagueNameStandings.text == "Ukrainian Premier League"){
                                countryImage.setImageResource(R.drawable.flag_ukraine)
                            }


                            if (leagueNameStandings.text == "Austrian Football Bundesliga"){
                                leagueImage.setImageResource(R.drawable.ic_austrian_football_bundesliga)
                            }
                            if (leagueNameStandings.text == "Belgium UEFA Europa League Play-Offs"){
                                leagueImage.setImageResource(R.drawable.ic_belgiumproleague)
                            }
                            if (leagueNameStandings.text == "Czech First League"){
                                leagueImage.setImageResource(R.drawable.ic_czech_first_league)
                            }
                            if (leagueNameStandings.text == "English Football League Championship"){
                                leagueImage.setImageResource(R.drawable.ic_english_football_league)
                            }
                            if (leagueNameStandings.text == "English Premier League"){
                                leagueImage.setImageResource(R.drawable.ic_premier_league)
                            }
                            if (leagueNameStandings.text == "UEFA Europa League"){
                                leagueImage.setImageResource(R.drawable.ic_europa_league)
                            }
                            if (leagueNameStandings.text == "UEFA Champions League"){
                                leagueImage.setImageResource(R.drawable.ic_uefa_champions_league_logo_2)
                            }
                            if (leagueNameStandings.text == "League 1"){
                                leagueImage.setImageResource(R.drawable.ic_league_1)
                            }
                            if (leagueNameStandings.text == "Bundesliga"){
                                leagueImage.setImageResource(R.drawable.ic_bundesliga)
                            }
                            if (leagueNameStandings.text == "Super League Greece 1"){
                                leagueImage.setImageResource(R.drawable.ic_super_league_greece_1)
                            }
                            if (leagueNameStandings.text == "Eredivisie"){
                                leagueImage.setImageResource(R.drawable.ic_eredivisie)
                            }
                            if (leagueNameStandings.text == "Serie A"){
                                leagueImage.setImageResource(R.drawable.ic_serie_a)
                            }
                            if (leagueNameStandings.text == "Serie B"){
                                leagueImage.setImageResource(R.drawable.ic_serie_b)
                            }
                            if (leagueNameStandings.text == "Primeira Liga"){
                                leagueImage.setImageResource(R.drawable.ic_primeira_liga)
                            }
                            if (leagueNameStandings.text == "Russian Premier League"){
                                leagueImage.setImageResource(R.drawable.ic_russian_premier_league)
                            }
                            if (leagueNameStandings.text == "La Liga"){
                                leagueImage.setImageResource(R.drawable.ic_la_liga)
                            }
                            if (leagueNameStandings.text == "Swiss Super League"){
                                leagueImage.setImageResource(R.drawable.ic_swiss_super_league)
                            }
                            if (leagueNameStandings.text == "Süper Lig"){
                                leagueImage.setImageResource(R.drawable.ic_super_lig)
                            }
                            if (leagueNameStandings.text == "Ukrainian Premier League"){
                                leagueImage.setImageResource(R.drawable.ic_ukrainian_premier_league)
                            }

                            Log.d(TAG, responseBody.toString())
                        }
                        override fun onFailure(call: Call<StandingsLeague>, t: Throwable) {
                            Log.e(TAG, "Not Found")
                        }
                    })
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LeagueFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LeagueFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}