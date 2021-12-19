package com.muhammadardani.dailysoccer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val matchesFragment = MatchesFragment()
    private val liveFragment = LiveFragment()
    private val leagueFragment = LeagueFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(matchesFragment)
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_schedule -> replaceFragment(matchesFragment)
                R.id.ic_live -> replaceFragment(liveFragment)
                R.id.ic_league -> replaceFragment(leagueFragment)
            }
            true

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}