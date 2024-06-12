package com.example.ptixiakiergasi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ptixiakiergasia.Screens
import com.example.ptixiakiergasia.ViewModel
import com.example.ptixiakiergasia.ui.theme.Background
import com.example.ptixiakiergasia.ui.theme.RobotoBoldItalicFontFamily
import com.example.ptixiakiergasia.ui.theme.RobotoFontFamily
import org.intellij.lang.annotations.JdkConstants.FontStyle


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun firstScreen(
    navController: NavController,
    viewModel: ViewModel
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        var isExpanded by remember { mutableStateOf(false) }
        val kaves = listOf("maziotis", "oiknomopoulos","Ass")
        var isSelected by rememberSaveable { mutableStateOf("") }
        var name by remember{ mutableStateOf("") }
        var isOpen by remember { mutableStateOf(true) }
        viewModel.storeName=name
        if(isOpen && name.isEmpty()) {
            EnterName(onClose = { isOpen = !isOpen }, savedName = { name = it })
        }


        Column(
            modifier = Modifier
                .background(Background)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(text = name, fontSize = 25.sp)

            Spacer(modifier = Modifier.padding(bottom = 15.dp))
            TextField(
                value = isSelected,
                onValueChange ={isSelected= it},
                readOnly = true,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White),
                trailingIcon ={
                    IconButton(onClick = { isExpanded=true }) {
                        Icon(imageVector = Icons.Default.ArrowDropDown,
                            contentDescription ="" )
                    }
                    DropdownMenu(
                        expanded = isExpanded,
                        onDismissRequest = { isExpanded=false},
                        modifier = Modifier
                            .clip(RoundedCornerShape(10.dp))
                            .fillMaxWidth(0.7f))
                    {
                        kaves.forEach { selectOption ->

                            DropdownMenuItem(
                                modifier = Modifier
                                    .background(Color.White),
                                text = { Text(text = selectOption, fontFamily = RobotoBoldItalicFontFamily)},
                                onClick = {
                                    isExpanded=false
                                    isSelected=selectOption
                                })
                        }

                    }
                }
            )
              Button(onClick = {
             if (isSelected.isNotEmpty())
             {
                 navController.navigate(Screens.Homepage.route)
                 viewModel.kavaName=isSelected
             }
              }) {
              Text(text = "Enter")
             }

        }
    }
}

@Composable
fun  EnterName(
    onClose:() -> Unit,
    savedName:(String)->Unit
){
    var name by remember { mutableStateOf("") }
   // var isOpen by remember { mutableStateOf(false) } isOpen=onClose()
  //  if(isOpen) {
        AlertDialog(
            onDismissRequest = {  },
            confirmButton = {
                Text(text = "Save",
                    modifier = Modifier
                        .clickable {
                           if(name.isNotEmpty()){
                               onClose()
                               savedName(name)
                           }
                        })
            },
            title = { Text(text = "Enter Store Name") },
            text = {
                TextField(
                    value = name,
                    onValueChange = { name = it }
                )
            }
        )
   // }
}


@Composable
@Preview(showBackground = true)
fun preview(){
    //firstScreen()
}