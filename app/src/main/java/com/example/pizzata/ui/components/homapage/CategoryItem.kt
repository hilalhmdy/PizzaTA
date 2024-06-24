package com.example.pizzata.ui.components.homapage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.R
import com.example.pizzata.model.Category
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun CategoryItem(
    category: Category,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(category.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .requiredSize(50.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(category.textCategory),
            fontSize = 10.sp,
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = true)
fun CategoryItemPreview() {
    PizzaTATheme{
        CategoryItem(
            category = Category(
                R.drawable.pizza,
                R.string.category,
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}