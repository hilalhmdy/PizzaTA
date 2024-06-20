package com.example.pizzata.ui.screen.order

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.model.OrderProgress
import com.example.pizzata.model.dummyOrderProgress
import com.example.pizzata.ui.components.order.CardOrderProgress

@Composable
fun OrderProgressScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        ListOrderProgress(dummyOrderProgress)
    }
}

@Preview(showBackground = true)
@Composable
fun OrderProgressScreenPreview() {
    OrderProgressScreen()
}

@Composable
fun ListOrderProgress(
    listOrderProgress: List<OrderProgress>,
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
