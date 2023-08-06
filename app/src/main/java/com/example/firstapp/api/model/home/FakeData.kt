package com.example.firstapp.api.model.home

import com.example.firstapp.R


class FakeData {
    private var city = listOf(
        CityData(R.drawable.image_city_one, "Coeurdes Alpes", "244 review"),
        CityData(R.drawable.image_city_two, "Coeurdes Alpes", "245 review"),
        CityData(R.drawable.image_city_three, "Coeurdes Alpes", "244 review")
    )

    fun getCityDataList(): List<CityData> {
        return city
    }

    fun getCityById(id: Int): CityData {
        return city[id]
    }
}