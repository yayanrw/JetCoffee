package com.heyproject.jetcoffee.model

import com.heyproject.jetcoffee.R

/**
Written by Yayan Rahmat Wijaya on 11/5/2022 13:31
Github : https://github.com/yayanrw
 **/

data class Menu(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyMenu = listOf(
    Menu(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menu(R.drawable.menu2, "Pumpkin Spice Latte", "Rp 18.000"),
    Menu(R.drawable.menu3, "Light Cappuccino", "Rp 20.000"),
    Menu(R.drawable.menu4, "Choco Creamy Latte", "Rp 16.000"),
)

val dummyBestSellerMenu = dummyMenu.shuffled()