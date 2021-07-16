package dev.emrizkiem.ecommerce.implement.feature.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.nex3z.notificationbadge.NotificationBadge
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.feature.cart.CartActivity

class DetailProductActivity : AppCompatActivity() {

    private var positionImageProduct = 0
    private var count = 0

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var badge: NotificationBadge
    private lateinit var btnAddToCart: MaterialButton

    val listenerPage = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            timer.cancel()
            timer.start()
        }
    }

    val timer = object : CountDownTimer(4000, 1000) {
        override fun onTick(millisUntilFinished: Long) {}

        override fun onFinish() {
            viewPager.currentItem = (viewPager.adapter as ImageProductAdapter)
                .setNextPage(viewPager.currentItem)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        viewPager = findViewById(R.id.view_pager)
        tabLayout = findViewById(R.id.tab_layout)
        btnAddToCart = findViewById(R.id.btn_add_to_cart)
        badge = findViewById(R.id.badge)

        val icCart: ImageView = findViewById(R.id.ic_cart)

        val viewPagerAdapter = ImageProductAdapter()
        viewPager.adapter = viewPagerAdapter
        viewPager.registerOnPageChangeCallback(listenerPage)
        TabLayoutMediator(tabLayout, viewPager) { _, _ ->
            viewPager.setCurrentItem(positionImageProduct, false)
        }.attach()
        slideOnImageProduct()

        icCart.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
            finish()
        }

        addToCart()
    }

    override fun onStop() {
        super.onStop()
        timer.cancel()
    }

    private fun slideOnImageProduct() {
        timer.cancel()
        timer.start()
    }

    private fun addToCart() {
        btnAddToCart.setOnClickListener {
            badge.setNumber(++count)
        }
    }
}