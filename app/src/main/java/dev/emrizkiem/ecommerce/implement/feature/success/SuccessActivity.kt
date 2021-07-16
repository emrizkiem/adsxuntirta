package dev.emrizkiem.ecommerce.implement.feature.success

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.feature.home.HomeActivity

class SuccessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)

        val backToShop: MaterialButton = findViewById(R.id.btn_back_to_shop)

        backToShop.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}