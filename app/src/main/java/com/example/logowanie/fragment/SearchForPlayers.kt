package com.example.logowanie.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.logowanie.AdapterPlayers
import com.example.logowanie.R

class SearchForPlayers : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_find_players, container, false)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_list_of_players)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = AdapterPlayers()

        val filterButton = view?.findViewById<ImageButton>(R.id.bt_filtr)
        filterButton?.setOnClickListener(){
            showFilterDialog()
        }

        return view
    }

    private fun showFilterDialog(){
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_box_filter)
        dialog.show()

        val saveButton = dialog.findViewById<Button>(R.id.btn_filter)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)
        val nameEditText = dialog.findViewById<EditText>(R.id.et_name)
        val locationEditText = dialog.findViewById<EditText>(R.id.et_location)
        val genderRadioGroup = dialog.findViewById<RadioGroup>(R.id.rg_gender)
        val ageEditText = dialog.findViewById<EditText>(R.id.et_age)

        saveButton.setOnClickListener(){

            dialog.dismiss()
        }
        cancelButton.setOnClickListener(){
            dialog.dismiss()
        }
    }

}