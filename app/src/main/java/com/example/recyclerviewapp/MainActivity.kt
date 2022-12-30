package com.example.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),CarAdapter.OnItemClickListener {
    private val cars = generaterDummyList(12)
    private val adapter = CarAdapter(cars, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        load()
    }

    fun load()
    {
        recycler_view.adapter = CarAdapter(cars,this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generaterDummyList(size : Int) : ArrayList<Cars_Item>{
        val list = ArrayList<Cars_Item>()

        for(i in 0 until size)
        {
            val drawable = when(i%3){
                0-> R.drawable.audi
                1-> R.drawable.bmw
                2-> R.drawable.toyota
                else -> R.drawable.any
            }

            if(i % 3 == 0)
            {
                val item = Cars_Item(drawable,"Audi", "Model $i")
                list+=item
            }

            else if(i%3==1)
            {
                val item = Cars_Item(drawable,"BMW", "Model $i")
                list+=item
            }

            else if(i%3==2)
            {
                val item = Cars_Item(drawable,"Toyota", "Model $i")
                list+=item
            }

            else
            {
                val item = Cars_Item(drawable,"UNKNOWN", "UNKNOWN")
            }

        }

        return list
    }


    fun insertCar(view : View)
    {

            val index : Int =  0

            val newCar = Cars_Item(R.drawable.any, "Altă Mașină", "Necunoscut")
            cars.add(index, newCar)
            adapter.notifyItemInserted(index)
            load()


    }

    var removeClickedCar : Int? = null

    fun removeCar(view : View)
    {
        if(removeClickedCar!=null && cars.size>=removeClickedCar!!)
        {
            cars.removeAt(removeClickedCar!!)
            adapter.notifyItemRemoved(removeClickedCar!!)
            removeClickedCar=null
        }

        else if(removeClickedCar==null)
        {
            Toast.makeText(this,"Please Choose a car!", Toast.LENGTH_SHORT).show()
        }

        load()
    }

    override fun onItemClick(position: Int) {
        val carSelected = cars[position].Brand + " " + cars[position].Name
        Toast.makeText(this,"$carSelected is clicked.", Toast.LENGTH_SHORT).show()
        removeClickedCar = position

    }


}