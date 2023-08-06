package com.example.firstapp.ui.fragment.homedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.firstapp.CityDetailsArgs
import com.example.firstapp.R
import com.example.firstapp.api.model.home.FakeData


class CityDetails : Fragment() {
    val args: CityDetailsArgs by navArgs()
    val getData = FakeData()
    lateinit var imageViewCityDetails: ImageView
    lateinit var textViewCityName: TextView
    lateinit var textViewCityReview: TextView
    lateinit var backArrow: ImageView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_city_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        getValue()
        handleClick()
    }

    private fun initViews() {
        backArrow = requireActivity().findViewById(R.id.image_view_details_back)
        imageViewCityDetails = requireActivity().findViewById(R.id.image_view_details_city_image)
        textViewCityName = requireActivity().findViewById(R.id.text_view_city_title)
        textViewCityReview = requireActivity().findViewById(R.id.text_view_city_details_review)
    }
    fun getValue() {
        val currentCity = getData.getCityById(args.CityId ?: 0)
        imageViewCityDetails.setImageResource(currentCity.image)
        textViewCityName.text = currentCity.name
        textViewCityReview.text = currentCity.review

    }
    fun handleClick(){
        backArrow.setOnClickListener {
            Navigation.findNavController(requireView()).popBackStack()
        }
    }
}