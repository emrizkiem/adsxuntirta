package dev.emrizkiem.ecommerce.learn.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import dev.emrizkiem.ecommerce.learn.ui.fragment.MainFragment
import dev.emrizkiem.ecommerce.learn.ui.fragment.intent.IntentFragment
import dev.emrizkiem.ecommerce.learn.ui.fragment.recyclerview.RecyclerviewFragment

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount() = NUM_TABS

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return MainFragment()
            1 -> return IntentFragment()
        }
        return RecyclerviewFragment()
    }

    companion object {
        const val NUM_TABS = 3
    }
}