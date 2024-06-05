package com.example.pizzata.ui.components.homapage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun CardActivityViews(
    id: Int,
    image: Int,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .width(250.dp)
            .height(84.dp)
    ){
        Image(
            painter = painterResource(image),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CardActivityPreview() {
    PizzaTATheme {
        CardActivityViews(
            1,
            R.drawable.pizza_banner,
        )
    }
}