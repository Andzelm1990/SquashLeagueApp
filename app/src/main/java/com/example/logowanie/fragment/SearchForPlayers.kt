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

/**
 * This class represents a fragment for searching and displaying players.
 */
class SearchForPlayers : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_find_players, container, false)

        // Find the RecyclerView in the layout
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_list_of_players)

        // Set a LinearLayoutManager to manage the items in a vertical list
        recyclerView?.layoutManager = LinearLayoutManager(context)

        // Set an adapter to the RecyclerView to display player data
        recyclerView?.adapter = AdapterPlayers()

        // Find and set click listener for the filter button
        val filterButton = view?.findViewById<ImageButton>(R.id.bt_filtr)
        filterButton?.setOnClickListener() {
            showFilterDialog()
        }

        return view
    }

    /**
     * Displays a filter dialog to allow the user to filter players.
     */
    private fun showFilterDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_box_filter)
        dialog.show()

        // Find UI elements and set click listeners for buttons
        val saveButton = dialog.findViewById<Button>(R.id.btn_filter)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)
        val nameEditText = dialog.findViewById<EditText>(R.id.et_name)
        val locationEditText = dialog.findViewById<EditText>(R.id.et_location)
        val genderRadioGroup = dialog.findViewById<RadioGroup>(R.id.rg_gender)
        val ageEditText = dialog.findViewById<EditText>(R.id.et_age)

        saveButton.setOnClickListener() {
            // Handle save button click here
            dialog.dismiss()
        }
        cancelButton.setOnClickListener() {
            // Handle cancel button click here
            dialog.dismiss()
        }
    }
}