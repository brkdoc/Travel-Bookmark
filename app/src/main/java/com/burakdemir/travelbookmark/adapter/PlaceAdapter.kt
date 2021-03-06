package com.burakdemir.travelbookmark.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.burakdemir.travelbookmark.databinding.RecyclerRowBinding
import com.burakdemir.travelbookmark.model.Place
import com.burakdemir.travelbookmark.view.MapsActivity

class PlaceAdapter(val placeList: List<Place>):RecyclerView.Adapter<PlaceAdapter.PlaceHolder>() {
    class PlaceHolder(val recyclerRowbinding: RecyclerRowBinding):RecyclerView.ViewHolder(recyclerRowbinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceHolder {
        val recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PlaceHolder(recyclerRowBinding)
    }

    override fun onBindViewHolder(holder: PlaceHolder, position: Int) {
        holder.recyclerRowbinding.recyclerViewTextView.text=placeList.get(position).name
        holder.itemView.setOnClickListener(){
            val intent=Intent(holder.itemView.context,MapsActivity::class.java)
            intent.putExtra("selectedPlace",placeList.get(position))
            intent.putExtra("info","old")
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return placeList.size
    }
}