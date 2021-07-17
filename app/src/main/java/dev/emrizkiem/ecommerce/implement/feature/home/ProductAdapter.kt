package dev.emrizkiem.ecommerce.implement.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Product
import dev.emrizkiem.ecommerce.implement.utils.CurrencyUtils

class ProductAdapter(
    private val listData: List<Product>,
    private val listener: (Product) -> Unit
) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val imgProduct: ImageView = view.findViewById(R.id.img_product)
        private val tvNameProduct: TextView = view.findViewById(R.id.tv_name_product)
        private val tvPriceProduct: TextView = view.findViewById(R.id.tv_price)

        fun bindItem(
            product: Product,
            listener: (Product) -> Unit
        ) {
            tvNameProduct.text = product.name
            tvPriceProduct.text = CurrencyUtils.simpleCovertCurrency(itemView.context, product.price.toString())
            Glide.with(itemView.context)
                .load(product.thumbnail)
                .into(imgProduct)

            itemView.setOnClickListener { listener(product) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listData[position], listener)
    }

    override fun getItemCount() = listData.size
}