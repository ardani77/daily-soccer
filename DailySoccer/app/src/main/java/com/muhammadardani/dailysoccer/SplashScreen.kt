package com.muhammadardani.dailysoccer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.muhammadardani.dailysoccer.R.xml.splashscreen_animation

class SplashScreen: AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)

        val splashscreenAnimation = AnimationUtils.loadAnimation(this, splashscreen_animation)
        val ImageView = findViewById<ImageView>(R.id.splashscreenView)
        ImageView.startAnimation(splashscreenAnimation)

        val splashScreenTimeOut = 3000
        val homeIntent = Intent(this@SplashScreen, MainActivity::class.java)

        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, splashScreenTimeOut.toLong())
    }
}