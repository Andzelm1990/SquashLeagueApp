package com.example.logowanie

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewaplication.ContactDataBase

class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val leyautInflater = LayoutInflater.from(parent.context)
        val contactRow = leyautInflater.inflate(R.layout.contact_row, parent, false)
        return MyViewHolder(contactRow)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
       return 8
    }
}

class MyViewHolder (val view: View): RecyclerView.ViewHolder(view)