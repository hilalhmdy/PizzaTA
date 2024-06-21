package com.example.pizzata.ui.screen.order.history

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pizzata.model.dummyOrderFinish

@Composable
fun DineInOrderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ListOrderFinish(dummyOrderFinish)
    }
}