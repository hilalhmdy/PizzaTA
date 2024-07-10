package com.example.pizzata.ui.components.homapage

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun CardMenuFavViews(
    image: Int,
    title: String,
    price: String,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = modifier
            .width(156.dp)
            .height(200.dp)
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()

        )
        Column(modifier = modifier
            .padding(top =6.dp)
        ){
            Text(
                text = title,
                maxLines = 2,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Rp. $price",
                maxLines = 2,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}


@Composable
@Preview(showBackground = true)
fun CardMenuFavPreview(){
    PizzaTATheme{
        CardMenuFavViews(
            R.drawable.menu1,
            "Yellow Creamy Pizza",
            "172.000",
        )
    }
}

