package com.example.pizzata.ui.components.order

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontVariation.width
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun CardOrderProgress(
    id : String,
    item: String,
    time : String,
    date : String,
    price: String,
    modifier: Modifier = Modifier
) {
    val showDialog =  remember { mutableStateOf(false) }

    if(showDialog.value)
        DialogOrderProgress(
            id = "ID11212ASAA",
            time = "17.50",
            date = "26 May 2023",
            type = "Plastik",
            coin = "300",
            earn = "2.400",
            onCancelClicked = { showDialog.value = false })

    Card(
        modifier = modifier
            .width(340.dp)
            .wrapContentHeight()
            .clickable {
                showDialog.value = true
            },
        shape = RoundedCornerShape(10.dp)
    ){
        Row(
            modifier = modifier
                .width(80.dp)
                .padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 12.dp)
        ){
            Image(
                painter = painterResource(R.drawable.pizza),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(20.dp)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .padding(start = 11.dp)
                    .weight(1.0f)
            ) {
                Text(
                    text = id,
                    maxLines = 1,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = "$item item",
                    maxLines = 10,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.CenterHorizontally),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = time,
                        maxLines = 10,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = "|",
                        maxLines = 10,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Text(
                        text = date,
                        maxLines = 10,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Rp. $price",
                    maxLines = 10,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun CardOrderPreview() {
    PizzaTATheme {
        CardOrderProgress(
            "ID121212131",
            "2",
            "17.40",
            "26 May 2023",
            "30.000"
        )
    }
}
