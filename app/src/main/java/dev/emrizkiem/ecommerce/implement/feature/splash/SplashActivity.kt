package dev.emrizkiem.ecommerce.implement.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.feature.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo: ImageView = findViewById(R.id.logo)
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)

        logo.startAnimation(animation)

        Handler(Looper.myLooper()!!).postDelayed(
            {
                startActivity()
                finish()
            },
            3000
        )
    }

    private fun startActivity() {
        startActivity(Intent(this, LoginActivity::class.java))
    }
}