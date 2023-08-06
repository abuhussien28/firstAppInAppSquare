package com.example.firstapp.ui.fragment.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.HomeScreenDirections
import com.example.firstapp.R
import com.example.firstapp.ui.fragment.home.adapter.HomeAdapter
import com.example.firstapp.api.model.home.FakeData


class HomeScreen : Fragment() , CityInteractionListener {
    lateinit var rv:RecyclerView
    val getData= FakeData()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getValues()
    }
    fun initViews(){
        rv=requireActivity().findViewById(R.id.recycler_view_city)
    }
    fun getValues(){
        val adapter= HomeAdapter(getData.getCityDataList(),this)
        rv.adapter=adapter
    }

    override fun onCityClick(city: Int) {
        val action = HomeScreenDirections.actionHomeScreenToCityDetails22(city)
        Navigation.findNavController(requireView()).navigate(action)
    }
}