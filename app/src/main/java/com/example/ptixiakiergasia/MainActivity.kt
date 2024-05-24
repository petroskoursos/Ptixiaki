package com.example.ptixiakiergasia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ptixiakiergasia.ui.theme.PtixiakiErgasiaTheme
import com.google.firebase.Firebase
import com.google.firebase.database.database

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val databse = Firebase.database
        super.onCreate(savedInstanceState)
        setContent {
            PtixiakiErgasiaTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomePage()
                }
            }
        }
    }
}

@Composable
fun HomePage() {
    val images= listOf(painterResource(id = R.drawable.coca), painterResource(id = R.drawable.cocacolazero),
        painterResource(id = R.drawable.loux))
    val itemName= listOf<String>("Coca-Cola","Coca-Cola Zero","Loux")
    Box(modifier = Modifier.fillMaxSize()){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            //horizontalAlignment = Alignment.CenterHorizontally
        ){
            LazyVerticalGrid(columns = GridCells.Fixed(2)){
                items(images.size) { index ->
                    Item(text = itemName[index], image =images[index] )
                }
            }
           Column(horizontalAlignment = Alignment.CenterHorizontally){
               Button(onClick = {  }) {
                   Text(text = "Save")
               }
           }
        }
    }

}

@Composable
fun Item(
    text:String,
    image:Painter){
//    Box(modifier = Modifier
//        .fillMaxSize()
//        .padding(top = 7.5.dp, bottom = 7.5.dp)
//
//    ){
    var itemQty by remember{ mutableStateOf<String>("") }
        Column(
            modifier = Modifier
                .fillMaxSize()
            , horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = image, contentDescription = text, contentScale = ContentScale.FillBounds)

            Row(modifier = Modifier
                .padding(15.dp)
            ){
                Column(horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = text)
                    OutlinedTextField(value = itemQty , onValueChange = { itemQty = it })
                }
            }
        }


    //}
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PtixiakiErgasiaTheme {
        HomePage()
    }
}