package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.firstapp.CityInteractionListener
import com.example.firstapp.R
import com.example.firstapp.model.CityData

class HomeAdapter(val data: List<CityData>, val listener: CityInteractionListener) :
    RecyclerView.Adapter<HomeAdapter.CityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentCity = data[position]
        holder.imageViewCity.setImageResource(currentCity.image)
        holder.textViewName.text = currentCity.name
        holder.textViewReview.text = currentCity.review
        holder.itemView.setOnClickListener { listener.onCityClick(position) }
    }

    class CityViewHolder(viewItem: View) : ViewHolder(viewItem) {
        var imageViewCity: ImageView = viewItem.findViewById(R.id.image_view_city)
        var textViewName: TextView = viewItem.findViewById(R.id.text_view_city_name)
        var textViewReview: TextView = viewItem.findViewById(R.id.text_view_city_review)
    }
}


