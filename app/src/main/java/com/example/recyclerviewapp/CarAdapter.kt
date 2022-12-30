package com.example.recyclerviewapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.exitem.view.*

class CarAdapter(private val carList : List<Cars_Item> , private val listener : OnItemClickListener) : RecyclerView.Adapter<CarAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.exitem, parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = carList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.brand.text = currentItem.Brand
        holder.model.text = currentItem.Name


    }
    override fun getItemCount() = carList.size


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), /*selected */ View.OnClickListener{
        val imageView : ImageView = itemView.image_view
        val brand : TextView = itemView.txtBrand
        val model : TextView = itemView.txtModel
        

        init {
           itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position : Int = adapterPosition
            if (position!= RecyclerView.NO_POSITION)
            {
                listener.onItemClick(position)
            }

        }


    }

    interface OnItemClickListener
    {
        fun onItemClick(position: Int)
        {

        }
    }

}