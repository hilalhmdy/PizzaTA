package com.example.pizzata.ui.screen.order.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material.Scaffold
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.model.OrderFinish
import com.example.pizzata.ui.components.order.CardOrderFinish
import com.example.pizzata.ui.screen.order.OrderTopBar
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OrderFinishScreen() {
    val tabsHistory = listOf(TabItemHistory.DeliveryOrder, TabItemHistory.TakeawayOrder, TabItemHistory.DineInOrder)
    val pagerState = rememberPagerState()

    Column(modifier = Modifier.padding(top = 10.dp)) {
        TabsHistory(tabs = tabsHistory, pagerState = pagerState)
        TabsContentHistory(tabs = tabsHistory, pagerState = pagerState)
    }
}

@Preview(showBackground = true)
@Composable
fun MoviesScreenPreview() {
    OrderFinishScreen()
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsHistory(tabs: List<TabItemHistory>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()
    // OR ScrollableTabRow()
    TabRow(
        backgroundColor = Color.Transparent,
        selectedTabIndex = pagerState.currentPage,
        contentColor = Color.White,
        indicator = {
//            TabRowDefaults.Indicator(
//                modifier = Modifier
//                    .pagerTabIndicatorOffset(pagerState, tabPositions)
//                    .height(0.dp)
//            )
        }) {
        tabs.forEachIndexed { index, tab ->
            // OR Tab()
            LeadingIconTab(
                icon = {},
                text = {
                    Text(
                        text = tab.title,
                        color = Color(0xFF1A395A)
                    )
                },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContentHistory(tabs: List<TabItemHistory>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen()
    }
}

@Composable
fun ListOrderFinish(
    listOrderFinish: List<OrderFinish>,
    modifier : Modifier = Modifier,
){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ){
        items(listOrderFinish){data ->
            CardOrderFinish(
                id = data.id,
                item = data.item,
                time = data.time,
                date = data.date,
                price = data.price,
                onClick = {}
            )
        }

    }
}
