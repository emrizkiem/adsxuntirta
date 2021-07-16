package dev.emrizkiem.ecommerce.implement.feature.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Courier

class CourierAdapter(private val list: List<Courier>) : RecyclerView.Adapter<CourierAdapter.ViewHolder>() {

    private var courierSelected = 0
    private lateinit var rv: RecyclerView

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        rv = recyclerView
        super.onAttachedToRecyclerView(recyclerView)
    }

    @Suppress("DEPRECATION")
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val clParent: ConstraintLayout = view.findViewById(R.id.cl_parent)
        private val imageView: ImageView = view.findViewById(R.id.img_courier)

        fun bindItem(courier: Courier) {

            imageView.setImageResource(courier.image)

            clParent.setOnClickListener {
                setSelectable()
                resetChildAt(position)
                if (clParent.isSelected) {
                    clParent.elevation = 2F
                    courierSelected = position
                } else {
                    clParent.elevation = 0f
                    courierSelected = -1
                }
            }
        }

        private fun setSelectable() {
            clParent.isSelected = !clParent.isSelected
        }

        private fun resetChildAt(position: Int) {
            if (courierSelected != -1 && courierSelected != position)
                rv.getChildAt(courierSelected).apply {
                    isSelected = false
                    elevation = 0F
                }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_courier, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position])
    }

    override fun getItemCount() = list.size
}