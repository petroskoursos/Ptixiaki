package com.example.ptixiakiergasia.Database.presetation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.ptixiakiergasia.Database.Entity

class State {
    val state: List<Entity> = emptyList()
    val itemName: MutableState<String> = mutableStateOf("")
    val itemQty: MutableState<String> = mutableStateOf("")
}