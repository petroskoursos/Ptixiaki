package com.example.ptixiakiergasia

sealed class Screens (val route:String){
    object Homepage : Screens(route = "HomePage")
    object Order_screen: Screens(route = "Order_Screen")
}