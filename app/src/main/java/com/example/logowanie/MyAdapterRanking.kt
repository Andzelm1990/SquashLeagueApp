package com.example.logowanie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaplication.ContactDataBase

class MyAdapterRanking : RecyclerView.Adapter<MyViewHolderRanking>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderRanking {
        val leyautInflater = LayoutInflater.from(parent.context)
        val tabelRow = leyautInflater.inflate(R.layout.tabel_row, parent, false)
        return MyViewHolderRanking(tabelRow)
    }

    override fun onBindViewHolder(holder: MyViewHolderRanking, position: Int) {

    }

    override fun getItemCount(): Int {
        return 10
    }
}

class MyViewHolderRanking (val view: View): RecyclerView.ViewHolder(view)