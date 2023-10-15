package com.example.logowanie.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.logowanie.R

class FragmentMyMatch : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_my_match, container, false)

        val filterButton = view?.findViewById<ImageButton>(R.id.bt_filtr)
        filterButton?.setOnClickListener(){
            showFilterDialog()
        }
        val addMachButton = view?.findViewById<ImageButton>(R.id.bt_add_mach)
        addMachButton?.setOnClickListener(){
            showAddDialog()
        }


        /*
        val recyclerView = view?.findViewById<RecyclerView>(R.id.rv_my_leagues)
        recyclerView?.layoutManager = LinearLayoutManager(context)
        recyclerView?.adapter = AdapterLigues()
        */
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

    private fun showAddDialog(){
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.dialog_box_add_mach)

        val autoCompleteTextPlayer1: AutoCompleteTextView? = dialog.findViewById(R.id.et_nick)
        val autoCompleteTextPlayer2: AutoCompleteTextView? = dialog.findViewById(R.id.et_location)

        val players = listOf("Gracz 1", "Gracz 2", "Gracz 3", "Gracz 4")
        val adapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, players)
        val adapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, players)

        autoCompleteTextPlayer1?.setAdapter(adapter1)
        autoCompleteTextPlayer2?.setAdapter(adapter2)


        val saveButton = dialog.findViewById<Button>(R.id.btn_add)
        val cancelButton = dialog.findViewById<Button>(R.id.btn_cancel)

        saveButton.setOnClickListener(){

            dialog.dismiss()
        }
        cancelButton.setOnClickListener(){
            dialog.dismiss()
        }
        dialog.show()
    }
}