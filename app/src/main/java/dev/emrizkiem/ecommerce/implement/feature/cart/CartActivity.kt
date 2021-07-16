package dev.emrizkiem.ecommerce.implement.feature.cart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.nex3z.notificationbadge.NotificationBadge
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Courier
import dev.emrizkiem.ecommerce.implement.data.Payment
import dev.emrizkiem.ecommerce.implement.feature.success.SuccessActivity

class CartActivity : AppCompatActivity() {

    private lateinit var cartAdapter: CartAdapter
    private lateinit var courierAdapter: CourierAdapter
    private lateinit var paymentAdapter: PaymentAdapter

    private lateinit var rvCart: RecyclerView
    private lateinit var rvCourier: RecyclerView
    private lateinit var rvPayment: RecyclerView
    private lateinit var btnCheckout: MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        rvCart = findViewById(R.id.rv_cart)
        rvCourier = findViewById(R.id.rv_courier)
        rvPayment = findViewById(R.id.rv_payment)
        btnCheckout = findViewById(R.id.btn_checkout)

        initDataCart()
        initDataCourier()
        initDataPayment()
        goToCheckoutNow()
    }

    private fun initDataCart() {
        rvCart.apply {
            cartAdapter = CartAdapter()
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = cartAdapter
        }
    }

    private fun initDataCourier() {
        val listCourier = listOf(
            Courier(image = R.drawable.ic_jnt),
            Courier(image = R.drawable.ic_jne)
        )

        rvCourier.apply {
            courierAdapter = CourierAdapter(listCourier)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = courierAdapter
        }
    }

    private fun initDataPayment() {
        val listPayment = listOf(
            Payment(image = R.drawable.ic_gopay),
            Payment(image = R.drawable.ic_ovo),
            Payment(image = R.drawable.ic_dana),
            Payment(image = R.drawable.ic_link)
        )

        rvPayment.apply {
            paymentAdapter = PaymentAdapter(listPayment)
            layoutManager = GridLayoutManager(context, 2)
            setHasFixedSize(true)
            adapter = paymentAdapter
        }
    }

    private fun goToCheckoutNow() {
        btnCheckout.setOnClickListener {
            val intent = Intent(this, SuccessActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}