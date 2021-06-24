package dev.emrizkiem.ecommerce.implement.feature.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.learn.ui.activity.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.myLooper()!!).postDelayed(
            {
                startActivity()
                finish()
            },
            1000L
        )
    }

    private fun startActivity() {
        startActivity(Intent(this, MainActivity::class.java))
    }
}