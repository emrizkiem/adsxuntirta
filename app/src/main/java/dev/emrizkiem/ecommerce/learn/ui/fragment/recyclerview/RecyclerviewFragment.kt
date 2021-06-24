package dev.emrizkiem.ecommerce.learn.ui.fragment.recyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.emrizkiem.ecommerce.R
import dev.emrizkiem.ecommerce.learn.adapter.RecyclerviewAdapter
import dev.emrizkiem.ecommerce.learn.data.Hero

class RecyclerviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_recyclerview, container, false)

        // Initialize recyclerview
        val recyclerView: RecyclerView = view.findViewById(R.id.rv_main)

        // Init list data
        val listHeroes = listOf(
            Hero(name = "Spider-Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"),
            Hero(name = "Black Panther", image = "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"),
            Hero(name = "Iron Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg"),
            Hero(name = "Dead Pool", image = "https://i.annihil.us/u/prod/marvel/i/mg/5/c0/537ba730e05e0/standard_xlarge.jpg"),
            Hero(name = "Captain Marvel", image = "https://i.annihil.us/u/prod/marvel/i/mg/c/10/537ba5ff07aa4/standard_xlarge.jpg"),
            Hero(name = "Ant Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/6/90/54ad7297b0a59/standard_xlarge.jpg"),
            Hero(name = "Spider-Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/9/30/538cd33e15ab7/standard_xlarge.jpg"),
            Hero(name = "Black Panther", image = "https://i.annihil.us/u/prod/marvel/i/mg/1/c0/537ba2bfd6bab/standard_xlarge.jpg"),
            Hero(name = "Iron Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/6/a0/55b6a25e654e6/standard_xlarge.jpg"),
            Hero(name = "Dead Pool", image = "https://i.annihil.us/u/prod/marvel/i/mg/5/c0/537ba730e05e0/standard_xlarge.jpg"),
            Hero(name = "Captain Marvel", image = "https://i.annihil.us/u/prod/marvel/i/mg/c/10/537ba5ff07aa4/standard_xlarge.jpg"),
            Hero(name = "Ant Man", image = "https://i.annihil.us/u/prod/marvel/i/mg/6/90/54ad7297b0a59/standard_xlarge.jpg")
        )

        // Init Adapter
        val adapter = RecyclerviewAdapter(listHeroes) { hero ->
            Toast.makeText(context, "Hero clicked ${hero.name}", Toast.LENGTH_SHORT).show()
        }

        // Set recyclerview and connection recylerview to adapter
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter

        return view
    }
}