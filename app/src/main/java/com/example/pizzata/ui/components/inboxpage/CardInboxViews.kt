package com.example.pizzata.ui.components.inboxpage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun CardInboxViews(
    title : String,
    description: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(340.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(10.dp)
    ){
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .padding(start = 20.dp, top = 12.dp, bottom = 12.dp, end = 20.dp)
            ) {
                Text(
                    text = "Sampah $title",
                    maxLines = 1,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Text(
                    text = description,
                    maxLines = 2,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
    }
}


@Composable
@Preview(showBackground = true)
fun CardOrderPreview() {
    PizzaTATheme {
        CardInboxViews(
            "Plastic",
            "Pesanan akan di ambil oleh kurir, mohon menunggu  mohon menung  mohon menung  mohon menung"
        )
    }
}
