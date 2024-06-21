package com.example.pizzata.model

data class OrderTakeaway (
    val id : String,
    val item: String,
    val status : Boolean,
    val description: String,
    val price : String,
    val time : String,
    val date : String,
)

val dummyOrderTakeaway = listOf(
    OrderTakeaway( "ID121212131", "2", true,  "Pesanan akan di ambil oleh kurir, mohon menunggu", "30.000","17.40", "26 May 2023"),
    OrderTakeaway( "ID121212131", "2", true,  "Pesanan akan di ambil oleh kurir, mohon menunggu", "30.000","17.40", "26 May 2023")
)