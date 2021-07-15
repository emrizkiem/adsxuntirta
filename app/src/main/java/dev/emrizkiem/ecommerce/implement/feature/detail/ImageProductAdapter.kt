package dev.emrizkiem.ecommerce.implement.feature.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.emrizkiem.ecommerce.R

class ImageProductAdapter : RecyclerView.Adapter<ImageProductAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Todo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_image_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Todo
    }

    override fun getItemCount(): Int = 3 ?: 1

    fun setNextPage(currentPosition: Int): Int {
        return if (currentPosition + 1 >= itemCount) {
            0
        } else {
            currentPosition + 1
        }
    }
}