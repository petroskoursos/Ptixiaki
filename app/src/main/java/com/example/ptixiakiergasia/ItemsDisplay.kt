package com.example.ptixiakiergasia

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ptixiakiergasia.ui.theme.Background
import com.example.ptixiakiergasia.ui.theme.RobotoFontFamily

@Composable
fun Item(
    text:String,
    image: Painter,
    onQuantityChange:(String,String)->Unit
) {

    var itemQty by rememberSaveable { mutableStateOf<String>("") }
    Box(modifier = Modifier
        .padding(15.dp)){
        Column(
            modifier = Modifier
                .clip(shape = RoundedCornerShape(10.dp))
                .background(Background)
                .padding(top = 10.dp)
            , horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(painter = image,
                contentDescription = text,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Background)
                    .shadow(2.dp)


            )
            Row(
                modifier = Modifier
                    .padding(15.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally){
                    Text(text = text, fontFamily = RobotoFontFamily)
                    OutlinedTextField(
                        value = itemQty, onValueChange = {
                        itemQty = it
                        onQuantityChange(text, it)

                    },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                        label = { Text(text = "Enter Amount", fontFamily = RobotoFontFamily, fontSize = 10.sp)},
                        modifier = Modifier
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(Color.White)
                        )

                }
            }

        }
    }

}

