package com.example.pizzata.ui.components.homapage

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.R
import com.example.pizzata.ui.theme.PizzaTATheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerSlider() {
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val bannerImages = listOf(
        R.drawable.banner1, // Placeholder banner images, replace with your own
        R.drawable.banner2,
    )
    LaunchedEffect(Unit) {
        while (true) {
            delay(3000) // Change the delay time (in milliseconds) to adjust the auto-scroll speed
            coroutineScope.launch {
                pagerState.animateScrollToPage((pagerState.currentPage + 1) % bannerImages.size)
            }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        HorizontalPager(
            state = pagerState,
            count = bannerImages.size,
        ) { page ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f),
                shape = RoundedCornerShape(0.dp)
            ) {
                Image(
                    painter = painterResource(id = bannerImages[page]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

    }
}


@Composable
@Preview(showBackground = true)
fun BannerSliderPreview(){
    PizzaTATheme {
        BannerSlider()
    }
}