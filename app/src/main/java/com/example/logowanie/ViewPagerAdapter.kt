package com.example.logowanie

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.logowanie.fragment.FragmentMyMatch
import com.example.logowanie.fragment.FragmentRankingTable
import com.example.logowanie.fragment.SearchForLeagues

class ViewPagerAdapter(fragment: Ranking) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentRankingTable()
            1 -> SearchForLeagues()
            2 -> SearchForLeagues()
            3 -> FragmentMyMatch()

            else -> FragmentRankingTable()
        }
    }
}