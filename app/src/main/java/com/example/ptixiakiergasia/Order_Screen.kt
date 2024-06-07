package com.example.ptixiakiergasia

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ptixiakiergasia.ui.theme.Background

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(
    viewModel: ViewModel,
    navController: NavController
){
    var quantities = viewModel.quantity
    Scaffold(
        topBar = {
            TopAppBar(
                colors =TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                )
                ,
                title = { Text(text = "Orders") }
            )
        },
        bottomBar = {
            BottomAppBar (
                containerColor= Color.Gray
            ){
                Row(modifier = Modifier
                    .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly){
                    Icon(imageVector = Icons.Default.Home,
                        contentDescription ="Home",
                        tint = Color.White,
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            }
                    )
                    Icon(imageVector = Icons.Default.ShoppingCart,
                    contentDescription ="Home",
                    tint = Color.White)
                }
            }
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /*TODO*/ },
                containerColor = Color.Green,
                contentColor = Color.Black,
                modifier = Modifier.fillMaxWidth(0.4f)
            ) {
               Text(text = "Send Order ${viewModel.tempPrice}",
                   fontWeight = FontWeight.Bold
               )
            }
        }
    ){ innerPadding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .background(Background)
        ){
           LazyColumn(modifier = Modifier
               .padding(innerPadding)
           ){
               //for((itemName,qty) in quantities){
               items(quantities.toList()){(itemName,qty) ->
                   Items(
                       itemName = itemName, qty = qty, viewModel = ViewModel() )
               }
           }


        }
    }
}


@Composable
fun Items(
    itemName:String,
    qty:String,
    viewModel: ViewModel){
    Column(modifier = Modifier
        .padding(horizontal = 15.dp)
    ){
        var itemPrice =""
        Row(modifier = Modifier
            .padding(vertical = 10.dp)
            .fillMaxWidth()
            .background(Color.White)
            .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(60.dp)
        ){

            itemPrice = viewModel.getPrice(itemName,qty)

            Text(text = "$itemName", color = Color.Black)
            Text(text = "$qty",color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(0.1f))
            Text(text = "$itemPrice",color = Color.Black,
                modifier = Modifier.fillMaxWidth(1f)
            , textAlign = TextAlign.End)
        }
    }
}




@Composable
@Preview(showBackground = true)
fun test(){

    //OrderScreen(viewModel = ViewModel())
}