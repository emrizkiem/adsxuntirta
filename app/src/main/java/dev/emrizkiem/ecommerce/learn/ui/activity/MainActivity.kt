package dev.emrizkiem.ecommerce.learn.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.learn.adapter.ViewPagerAdapter

class MainActivity : AppCompatActivity(){

    // Initialize viewPager and tabLayout
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private val menusTab = arrayOf("Main", "Intent", "Recyclerview")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Lifecycle", "Method onCreate Activity running")

        // Hubungkan variable yg sudah dibuat diatas dengan id yg ada di activity_main.xml
        viewPager = findViewById(R.id.viewPager)
        tabLayout = findViewById(R.id.tabLayout)

        // Initialize ViewPagerAdapter
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        // Called to configure the tab for the page at the specified position
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = menusTab[position]
        }.attach()
    }

    override fun onStart() {
        super.onStart()
        Log.d("Lifecycle", "Method onStart Activity running")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "Method onResume Activity running")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Lifecycle", "Method onPause Activity running")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Lifecycle", "Method onStop Activity running")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Lifecycle", "Method onDestroy Activity running")
    }
}