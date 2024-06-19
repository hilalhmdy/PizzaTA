package com.example.pizzata.model

data class OrderProgress (
    val id : String,
    val item: String,
    val status : Boolean,
    val description: String,
    val price : String,
    val time : String,
    val date : String,
)

val dummyOrderProgress = listOf(
    OrderProgress( "ID121212131", "2", true,  "Pesanan akan di ambil oleh kurir, mohon menunggu", "30.000","17.40", "26 May 2023"),
    OrderProgress( "ID121212131", "2", true,  "Pesanan akan di ambil oleh kurir, mohon menunggu", "30.000","17.40", "26 May 2023")
)