package dev.emrizkiem.ecommerce.learn.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.learn.data.Hero

class RecyclerviewAdapter(
    private val heroes: List<Hero>,
    private val listener: (Hero) -> Unit
) : RecyclerView.Adapter<RecyclerviewAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvName: TextView = view.findViewById(R.id.tv_hero_name)
        var imgHero: ImageView = view.findViewById(R.id.img_heroes)

        fun bindItem(item: Hero) {
            tvName.text = item.name
            Glide.with(itemView.context)
                .load(item.image)
                .into(imgHero)

            itemView.setOnClickListener {
                listener(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_hero, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(heroes[position])
    }

    override fun getItemCount() = heroes.size

}