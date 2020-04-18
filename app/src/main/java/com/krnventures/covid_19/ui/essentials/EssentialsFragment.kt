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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.ButterKnife
import com.krnventures.covid_19.R
import com.krnventures.covid_19.adapters.EssentialsAdapter
import com.krnventures.covid_19.dtos.RealEstateDTO
import kotlinx.android.synthetic.main.fragment_essentials.*


class EssentialsFragment : Fragment() {

    private lateinit var essentialsViewModel: EssentialsViewModel
    private var realEstateDTO: ArrayList<RealEstateDTO>? = null
    private lateinit var heythere:RealEstateDTO


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_essentials, container, false)
        ButterKnife.bind(this, view)
        setUp()

        val txtview:TextView=view.findViewById(R.id.textView3)
        // txtview.text=heythere.price

        essentialsViewModel.response.observe(viewLifecycleOwner, Observer {
            txtview.text = it[0].toString()
            realEstateDTO=it
        })
        val essentialsAdapter = realEstateDTO?.let { EssentialsAdapter(it) }

        val essentialsList:RecyclerView=view.findViewById(R.id.rv_essentials)
        essentialsList.adapter = essentialsAdapter
        essentialsList.setHasFixedSize(true)
        essentialsList.layoutManager = LinearLayoutManager(activity) // or this.context
        essentialsList.isNestedScrollingEnabled = false

        val adapter = realEstateDTO?.let { EssentialsAdapter(it) }
        essentialsList.adapter=adapter

        val ss:Spinner=view.findViewById(R.id.spinner_states)
        val sc:Spinner=view.findViewById(R.id.spinner_category)
        populateSpinner(ss)
        populateSpinner(sc)

        return view
    }

    private fun setUp(){

        assignViewModels()
        subscribeViewModel()
    }

    private fun subscribeViewModel() {
        //todo check internet connection
        getFaqData()
    }

    private fun assignViewModels(){
        essentialsViewModel = ViewModelProviders.of(this).get(EssentialsViewModel::class.java)
    }

    private fun getFaqData(){
       // essentialsViewModel.getEssentialsData().observe(this, )
    }


    //populate spinner
    private fun populateSpinner(spinner: Spinner) {
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
