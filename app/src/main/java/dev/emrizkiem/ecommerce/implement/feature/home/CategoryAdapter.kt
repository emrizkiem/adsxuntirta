package dev.emrizkiem.ecommerce.implement.feature.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.imageview.ShapeableImageView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.implement.data.Category

class CategoryAdapter(
    private val listData: List<Category>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        private val imgCategory: ShapeableImageView = view.findViewById(R.id.img_category)
        private val tvCategory: TextView = view.findViewById(R.id.tv_category)

        fun bindItem(category: Category) {
            tvCategory.text = category.name

            Glide.with(itemView.context)
                .load(category.image)
                .into(imgCategory)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}