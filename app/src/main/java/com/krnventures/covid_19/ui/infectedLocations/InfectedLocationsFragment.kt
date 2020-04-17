package com.krnventures.covid_19.ui.infectedLocations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.krnventures.covid_19.R


class InfectedLocationsFragment : Fragment() {

    private lateinit var dashboardViewModel: InfectedLocationsViewModel
    private lateinit var mMap: GoogleMap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(InfectedLocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_infected_locations, container, false)

        //mapView

        return root
    }
}
