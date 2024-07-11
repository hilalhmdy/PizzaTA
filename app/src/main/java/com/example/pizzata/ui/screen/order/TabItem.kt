package com.example.pizzata.ui.screen.order

import androidx.compose.runtime.Composable
import com.example.pizzata.ui.screen.order.history.OrderFinishScreen
import com.example.pizzata.ui.screen.order.ongoing.OrderProgressScreen

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object OrderProgress : TabItem( "On Going", { OrderProgressScreen() })
    object OrderFinish : TabItem( "History", { OrderFinishScreen() })
}