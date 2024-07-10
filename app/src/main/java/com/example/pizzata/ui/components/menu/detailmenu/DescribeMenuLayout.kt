package com.example.pizzata.ui.components.menu.detailmenu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun DescribeMenuLayout(
    title: String,
    describe : String,
    price : String,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 20.dp)
    ) {
        Row(
        ) {
            Column( modifier = modifier
                .weight(1.0f)
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
            }
            Text(
                text = price,
                maxLines = 10,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = describe,
            maxLines = 10,
            fontSize = 12.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(end = 30.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun DescribeMenuPreview(){
    PizzaTATheme {
        DescribeMenuLayout(
            "Full Creamy Pizza",
            "Pizza dengan campuran keju dan daging dan super pizza dengan campuran keju dan daging" ,
            "78.000"
        )
    }
}