package com.muhammadardani.dailysoccer

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import com.muhammadardani.dailysoccer.data.MatchesAdapter
import com.muhammadardani.dailysoccer.data.api.RetroInstance
import com.muhammadardani.dailysoccer.data.api.SoccerApi
import com.muhammadardani.dailysoccer.data.response.Match
import kotlinx.android.synthetic.main.fragment_matches.*
import kotlinx.android.synthetic.main.fragment_matches.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MatchesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MatchesFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var matchDay : TextView
    lateinit var list_match: ListView   //list view

    lateinit var adapter: com.muhammadardani.dailysoccer.data.MatchesAdapter

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
        val view = inflater.inflate(R.layout.fragment_matches, container, false)
        matchDay = view.matchDay
        list_match = view.matchList
        val retro = RetroInstance().getInstance().create(SoccerApi::class.java)
        retro.getMatch().enqueue(object : Callback<Match> {
            override fun onResponse(call: Call<Match>, response: Response<Match>) {
                val responseBody = response.body()
                adapter = MatchesAdapter(responseBody!!, activity!!)
                list_match.adapter = adapter
                Log.d(TAG, responseBody.toString())

            }
            override fun onFailure(call: Call<Match>, t: Throwable) {
                Log.e(TAG, "Not Found")
                Log.e(TAG, retro.toString())
            }
        })

        matchDay.text = "today"

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MatchesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MatchesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}