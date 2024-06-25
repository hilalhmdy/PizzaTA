package com.example.pizzata.ui.components.homapage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.BorderCard
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun CardRewardsViews(
    icon: Int,
    title: String,
    input: Int,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .width(142.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        border = BorderStroke(0.5.dp, BorderCard)
    ){
        Row(
            modifier = modifier
                .width(80.dp)
                .padding(start = 12.dp, top = 12.dp, bottom = 12.dp)
        ){
            Image(
                painter = painterResource(icon), 
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(20.dp)
            )
            Column( modifier = Modifier
                .padding(start = 11.dp)
                .weight(1.0f)
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
                Text(
                    text = "Level $input",
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardRewardsPreview() {
    PizzaTATheme {
        CardRewardsViews(
            R.drawable.pizza,
            "Rewards",
            2
        )
    }
}
