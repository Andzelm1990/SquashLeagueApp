package com.example.logowanie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterPlayers : RecyclerView.Adapter<MyViewHolderRanking>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderRanking {
        val leyautInflater = LayoutInflater.from(parent.context)
        val tabelRow = leyautInflater.inflate(R.layout.row_player, parent, false)
        return MyViewHolderRanking(tabelRow)
    }
    override fun onBindViewHolder(holder: MyViewHolderRanking, position: Int) {

    }
    override fun getItemCount(): Int {
        return 10
    }
}