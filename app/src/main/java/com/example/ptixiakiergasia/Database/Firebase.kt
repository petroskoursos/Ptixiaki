package com.example.ptixiakiergasia.Database

import com.google.firebase.Firebase
import com.google.firebase.database.database

fun saveToFirebase(quantities: Map<String, String>) {
    val database = Firebase.database
    //the name of the kava
    val kava = "Maziotis"
    //the name of the store
    val storeName = "Happy Jungle"
    //the reference of the kava
    val kavaRef = database.reference.child(kava)
    //Under the kava name goes the store
    val storeRef = kavaRef.child(storeName)

    //passing through the items and puts it in the store page
    for ((itemName, qty) in quantities) {
        storeRef.child(itemName).setValue(qty)
    }
}