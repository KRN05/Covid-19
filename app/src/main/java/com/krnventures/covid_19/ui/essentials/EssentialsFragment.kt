package com.krnventures.covid_19.ui.essentials

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.krnventures.covid_19.R

class EssentialsFragment : Fragment() {

    private lateinit var homeViewModel: EssentialsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(EssentialsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_essentials, container, false)

        //spinners
        val spinnerStates: Spinner =root.findViewById(R.id.spinner_states)
        val spinnerCategory: Spinner =root.findViewById(R.id.spinner_category)
        populateSpinner(spinnerStates, "spinner_states")
        populateSpinner(spinnerCategory, "spinner_category")

        return root
    }

    private fun populateSpinner(spinner: Spinner, spinnerName: String) {
        ArrayAdapter.createFromResource(
            requireActivity().applicationContext,
            R.array.spinner_states,
            android.R.layout.simple_spinner_item
        ).also {
            // Specify the layout to use when the list of choices appears
            it.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = it
        }
    }
}










//  val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })