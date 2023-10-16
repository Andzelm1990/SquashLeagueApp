package com.example.logowanie.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logowanie.MyAdapterRanking
import com.example.logowanie.R

/**
 * This class represents a fragment for displaying a ranking table.
 */
class FragmentRankingTable : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)

        // Find the RecyclerView in the layout
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rc_fragment_ranking)

        // Set a LinearLayoutManager to manage the items in a vertical list
        recyclerView?.layoutManager = LinearLayoutManager(context)

        // Set an adapter to the RecyclerView to display ranking data
        recyclerView?.adapter = MyAdapterRanking()

        return view
    }
}