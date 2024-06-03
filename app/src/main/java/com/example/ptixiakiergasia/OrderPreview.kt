package com.example.ptixiakiergasia

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController

@Composable
fun OrderPreview(
    quantities: Map<String,String>,
){
    Box(modifier = Modifier
        .fillMaxSize()){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ){
            for((itemName,qty) in quantities){
                Text(text = "$itemName : $qty")

            }
        }
    }
}



@Composable
@Preview(showBackground = true)
fun OPreview(){
    //Orders(quantities = )
}