package com.example.pizzata.ui.screen.order.history

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItemHistory(var title: String, var screen: ComposableFun) {
    object DeliveryOrder : TabItemHistory( "Delivery", { DeliveryOrderScreen() })
    object TakeawayOrder : TabItemHistory( "Take Away", { TakeawayOrderScreen() })
    object DineInOrder : TabItemHistory("Dine in", { DineInOrderScreen() })
}