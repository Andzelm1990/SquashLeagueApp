package com.example.logowanie.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.logowanie.R

/**
 * This class represents a fragment for managing and displaying user matches.
 */
class FragmentMyMatch : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_match, container, false)

        // Find and set click listeners for filter and add buttons
        val filterButton = view?.findViewById<ImageButton>(R.id.bt_filtr)
        filterButton?.setOnClickListener() {
            showFilterDialog()
        }
        val addMachButton = view?.findViewById<ImageButton>(R.id.bt_add_mach)
        addMachButton?.setOnClickListener() {
            showAddDialog()
        }
        return view
    }

    /**
     * Displays a filter dialog to allow the user to filter matches.
     */
    private fun showFilterDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_box_filter)
        dialog.show()

        // Find UI elements and set click listeners
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

    /**
     * Displays a dialog for adding a new match.
     */
    private fun showAddDialog() {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_box_add_mach)

        // Find UI elements and set up auto-complete text views
        val autoCompleteTextPlayer1: AutoCompleteTextView? = dialog.findViewById(R.id.et_nick)
        val autoCompleteTextPlayer2: AutoCompleteTextView? = dialog.findViewById(R.id.et_location)

        // Provide data for auto-complete
        val players = listOf("Player 1", "Player 2", "Player 3", "Player 4")
        val adapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, players)
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, players)

        autoCompleteTextPlayer1?.setAdapter(adapter1)
        autoCompleteTextPlayer2?.setAdapter(adapter2)

        // Find and set click listeners for buttons
        val saveButton = dialog.findViewById<Button>(R.id.btn_add)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        saveButton.setOnClickListener() {
            // Handle save button click here
            dialog.dismiss()
        }
        cancelButton.setOnClickListener() {
            // Handle cancel button click here
            dialog.dismiss()
        }
        dialog.show()
    }
}