package com.example.pizzata.ui.screen.order

import androidx.compose.runtime.Composable

typealias ComposableFun = @Composable () -> Unit

sealed class TabItem(var title: String, var screen: ComposableFun) {
    object OrderProgress : TabItem( "Berlangsung", { OrderProgressScreen() })
    object OrderFinish : TabItem( "Selesai", { OrderFinishScreen() })
}