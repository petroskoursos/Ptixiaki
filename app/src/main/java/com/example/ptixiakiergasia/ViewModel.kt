package com.example.ptixiakiergasia

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.system.exitProcess

class ViewModel:ViewModel(){
    private val _price = mutableStateOf(mapOf<String,String>())
    private val _quantity = (mapOf<String,String>())

    var quantity: Map<String,String> = _quantity
    var mapSize : Int = 0
    var prices : Double =0.0

    var tempPrice: Double=0.0

    fun getPrice(_itemName:String,qty:String):String
    {
        var quantity = qty.toInt()

        val price =when(_itemName){
            "Coca Cola" -> 2.0
            "Coca Cola Zero" ->2.0
            else -> 1.0
        }
        tempPrice= quantity*price
        prices = tempPrice


        return String.format("%.2f",tempPrice)
    }
    fun getTotalPrice():Double{
        return tempPrice
    }

    fun returnQty(qty:String,newqty:String){

    }
}
