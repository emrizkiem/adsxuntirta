package dev.emrizkiem.ecommerce.implement.feature.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.firebase.auth.FirebaseAuth
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.feature.detail.DetailProductActivity
import dev.emrizkiem.ecommerce.implement.feature.login.LoginActivity

class HomeActivity : AppCompatActivity() {

    private lateinit var homeAdapter: HomeAdapter

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView: RecyclerView = findViewById(R.id.rv_product)
        val imgLiveRoom: ShapeableImageView = findViewById(R.id.ic_live_room)
        val icLogout: ImageView = findViewById(R.id.ic_logout)

        auth = FirebaseAuth.getInstance()

        if (auth.currentUser == null) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            Log.d("Check User", "Already logged in")
        }

        icLogout.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

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