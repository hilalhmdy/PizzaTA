package com.example.pizzata.ui.screen.order.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pizzata.model.OrderProgress
import com.example.pizzata.model.OrderTakeaway
import com.example.pizzata.model.dummyOrderTakeaway
import com.example.pizzata.ui.components.order.CardOrderProgress

@Composable
fun TakeawayOrderScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        ListOrderTakeaway(dummyOrderTakeaway)
    }
}

@Composable
fun ListOrderTakeaway(
    listOrderProgress: List<OrderTakeaway>,
    modifier : Modifier = Modifier,
){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ){
        items(listOrderProgress){data ->
            CardOrderProgress(
                id = data.id,
                item = data.item,
                time = data.time,
                date = data.date,
                price = data.price,
                onClick = {}
            )
        }
    }
}