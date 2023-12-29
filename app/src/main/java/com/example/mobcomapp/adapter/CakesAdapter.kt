package com.example.mobcomapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mobcomapp.R
import com.example.mobcomapp.entities.menus
import kotlinx.android.synthetic.main.menu_item.view.*
import java.nio.file.Files.size

class CakesAdapter: RecyclerView.Adapter<CakesAdapter.CakeViewHolder>() {

    var arrCakeMenu = ArrayList<menus>()

    class CakeViewHolder(view: View): RecyclerView.ViewHolder(view){

    }

    fun setData(arrData : List<menus>){
        arrCakeMenu = arrData as ArrayList<menus> /* = java.util.ArrayList<com.example.mobcomapp.entities.menus> */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CakeViewHolder {
        return CakeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.menu_item,parent,false))
    }

    override fun getItemCount(): Int {
        return arrCakeMenu.size
    }

    override fun onBindViewHolder(holder: CakeViewHolder, position: Int) {
        holder.itemView.cake_name.text = arrCakeMenu[position].menuName
    }
}