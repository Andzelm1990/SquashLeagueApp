package com.example.logowanie

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.logowanie.fragment.FragmentRankingTable
import com.example.logowanie.fragment.SearchForPlayers

class ViewPagerAdapterCommunity(fragment: CommunityActivity) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> SearchForPlayers()
            1 -> SearchForPlayers()
            2 -> SearchForPlayers()
            else -> FragmentRankingTable()
        }
    }
}