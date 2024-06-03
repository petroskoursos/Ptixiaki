package com.example.ptixiakiergasia

sealed class Screen(val route: String){

    object Home: Screen(route = "Home_Screen")

    object  Details: Screen(route = "Details_Screen")

}