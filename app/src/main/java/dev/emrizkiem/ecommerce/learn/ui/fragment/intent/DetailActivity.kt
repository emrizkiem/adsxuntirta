package dev.emrizkiem.ecommerce.learn.ui.fragment.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import dev.emrizkiem.ecommerce.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Initialize textview
        val tvDataReceived: TextView = findViewById(R.id.tv_data_received)

        // Get data from fragment
        val name = intent.getStringExtra(NAME)
        val age = intent.getIntExtra(AGE, 0)

        // Ambil dan gabung data yg dikirim dari halaman sebelumnya
        val text = "Nama : $name, \nUmur Anda : $age"
        tvDataReceived.text = text
    }

    // Function back to previous page
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    // Variable global
    companion object {
        const val AGE = "age"
        const val NAME = "name"
    }
}