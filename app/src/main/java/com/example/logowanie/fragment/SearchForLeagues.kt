package com.example.logowanie.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logowanie.AdapterLigues
import com.example.logowanie.R

class SearchForLeagues : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_search_for_leagues, container, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_fragment_search_for_leagues)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = AdapterLigues()


        val filterButton = view?.findViewById<ImageButton>(R.id.bt_filtr)
        filterButton?.setOnClickListener(){
            showFilterDialog()
        }
        return view
    }

    private fun showFilterDialog(){
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_box_filter_league)
        dialog.show()

        val saveButton = dialog.findViewById<Button>(R.id.btn_filter)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        saveButton.setOnClickListener(){

            dialog.dismiss()
        }
        cancelButton.setOnClickListener(){
            dialog.dismiss()
        }
    }
}