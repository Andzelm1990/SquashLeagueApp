package com.example.logowanie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FragmentRankingTable : Fragment() {





    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_ranking, container, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rc_fragment_ranking)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = MyAdapterRanking()

        return view
    }


}