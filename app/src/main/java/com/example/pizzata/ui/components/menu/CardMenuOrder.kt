package com.example.pizzata.ui.components.menu

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.BorderCard
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.ui.theme.PrimaryColor
import com.example.pizzata.ui.theme.Shapes
import com.example.pizzata.ui.theme.Shapes_Larger
import com.example.pizzata.ui.theme.TextColor

@Composable
fun CardMenuOrder(
    image: Int,
    title: String,
    price: String,
    describe: String,
    onClick: ()->Unit,
    modifier: Modifier = Modifier,
){
    Card(
        modifier = modifier
            .width(340.dp)
            .height(80.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = 0.dp,
        border = BorderStroke(0.5.dp, BorderCard)
    ){
        Row(
            modifier = modifier
                .width(300.dp)
                .padding(start = 12.dp, top = 12.dp, bottom = 12.dp, end = 12.dp)
        ){
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .size(48.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 11.dp, top = 4.dp)
                    .weight(1.0f)
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = describe,
                    maxLines = 3,
                    color = TextColor,
                    fontSize = 8.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Column( modifier = Modifier
                .padding(start = 34.dp, top = 8.dp, end = 12.dp)
            ) {
                Text(
                    text = price,
                    maxLines = 1,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Button(
                    onClick = {
                        onClick()
                    },
                    shape = Shapes.medium,
                    colors = ButtonDefaults.buttonColors(PrimaryColor),
                    contentPadding = PaddingValues(0.dp),
                    modifier = modifier
                        .width(54.dp)
                        .height(20.dp)
                ) {
                    Text(
                        text = "Pesan",
                        color = Color.White,
                        fontSize = 8.sp,
                        fontWeight = FontWeight.Medium)
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardMenuOrderPreview(){
    PizzaTATheme {
        CardMenuOrder(
            R.drawable.pizza,
            "Choco Cheese",
            "105.200",
            "Pizza dengan aroma yang lezat ",
            onClick = {})
    }
}