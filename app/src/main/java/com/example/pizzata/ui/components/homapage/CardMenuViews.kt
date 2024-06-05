package com.example.pizzata.ui.components.homapage
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.ui.theme.Green_1
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.R

@Composable
fun CardMenuViews(
    navigate: () -> Unit,
    icon: Int,
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clickable { navigate() },
        shape = RoundedCornerShape(10.dp),
        backgroundColor = color
    ){
        Row(
            modifier = modifier
                .width(80.dp)
                .padding(start = 14.dp, top = 12.dp, bottom = 12.dp)
        ){
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 3.dp)
                    .size(30.dp)
            )
            Column( modifier = Modifier
                .padding(start = 16.dp, top = 2.dp)
                .weight(1.0f)
            ) {
                Text(
                    text = title,
                    maxLines = 1,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = description,
                    maxLines = 1,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Normal
                )
            }
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight ,
                contentDescription = "",
                modifier = Modifier
                    .padding(top = 5.dp, end = 24.dp)
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CardMenuPreview() {
    PizzaTATheme {
        CardMenuViews(
            {},
            R.drawable.recycling,
            "Jual Sampah",
            "Bersihkan lingkunganmu sekarang",
            Green_1
        )
    }
}
