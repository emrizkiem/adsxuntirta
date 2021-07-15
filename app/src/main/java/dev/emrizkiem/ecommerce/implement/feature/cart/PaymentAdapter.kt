package dev.emrizkiem.ecommerce.implement.feature.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Payment

class PaymentAdapter(
    private val list: List<Payment>
): RecyclerView.Adapter<PaymentAdapter.ViewHolder>() {

    private var paymentSelected = 0
    private lateinit var recyclerView: RecyclerView

    @Suppress("DEPRECATION")
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val clParent: ConstraintLayout = view.findViewById(R.id.cl_parent)
        private val imgPayment: ImageView = view.findViewById(R.id.img_payment)

        fun bindItem(payment: Payment) {

            imgPayment.setImageResource(payment.image)

            clParent.setOnClickListener {
                setSelectable()
                resetChildAt(position)
                if (clParent.isSelected) {
                    clParent.elevation = 2F
                    paymentSelected = position
                } else {
                    clParent.elevation = 0f
                    paymentSelected = -1
                }
            }
        }

        private fun setSelectable() {
            clParent.isSelected = !clParent.isSelected
        }

        private fun resetChildAt(position: Int) {
            if (paymentSelected != -1 && paymentSelected != position)
                recyclerView.getChildAt(paymentSelected).apply {
                    isSelected = false
                    elevation = 0F
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_payment, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount() = list.size
}