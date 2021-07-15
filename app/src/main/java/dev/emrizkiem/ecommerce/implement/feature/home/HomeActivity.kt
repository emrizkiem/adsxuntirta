package dev.emrizkiem.ecommerce.implement.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.feature.detail.DetailProductActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var homeAdapter: HomeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView: RecyclerView = findViewById(R.id.rv_product)
        val imgLiveRoom: ShapeableImageView = findViewById(R.id.ic_live_room)

        imgLiveRoom.setOnClickListener {
            val intent = Intent(this, DetailProductActivity::class.java)
            startActivity(intent)
        }

        recyclerView.apply {
            homeAdapter = HomeAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }
}