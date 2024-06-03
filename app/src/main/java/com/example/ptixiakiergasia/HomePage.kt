package com.example.ptixiakiergasia

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.ptixiakiergasia.Database.saveToFirebase
import com.example.ptixiakiergasia.ui.theme.Background

@Composable
fun HomePage(
    viewModel: ViewModel,
    navController: NavController
){
    // images
    val imageResIds = listOf(
        R.drawable.cocacola,
        R.drawable.cocacolazero,
        R.drawable.kokkinohmigluko,
        R.drawable.kokkinoxhro,
        R.drawable.leukohmigluko,
        R.drawable.leukoxhro2,
        R.drawable.lemonita,
        R.drawable.perrier,
        R.drawable.luxportokalada,
        R.drawable.rozexhro,
        R.drawable.grapefruit,
        R.drawable.lemoni,
        R.drawable.vikossprite,
        //R.drawable.vikos_gazoza
    )
    val images = imageResIds.map { painterResource(id = it) }
    //names
    val itemName = listOf<String>(
        "Coca Cola",
        "Coca Cola Zero",
        "Κοκκινο ημ",
        "Κοκκινο Ξηρο",
        "Λευκο ημ",
        "Λευκο Ξηρο",
        "Λουξ Λεμοναδα",
        "perrier_lemoni",
        "portokalada",
        //"portokalada_mple",
        "roze_xhro",
        "schweppes_grapfruit",
        "schewppes_lemoni",
        "vikos_gazoza"
    )

    var quantities by rememberSaveable { mutableStateOf(mapOf<String, String>()) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),

            ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.padding(15.dp)
            ){
                //call the fuction that displays the items
                items(images.size) { index ->
                    Item(
                        text = itemName[index],
                        image = images[index],
                        //on value change it updates the qty of the map
                        onQuantityChange = { itemName, qty ->
                            quantities = quantities.toMutableMap().apply { put(itemName, qty) }

                        })
                }
            }
        }

        Button(onClick = {
            viewModel.quantity=quantities
            viewModel.mapSize=quantities.count()
            navController.navigate(Screens.Order_screen.route)
        }) {
            Text(text = "Save")
        }

    }
}
