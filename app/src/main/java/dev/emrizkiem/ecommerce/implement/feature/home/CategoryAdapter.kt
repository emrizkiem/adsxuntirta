package dev.emrizkiem.ecommerce.implement.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Category

class CategoryAdapter(
    private val listData: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        // Todo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Todo
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}