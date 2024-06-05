package com.example.pizzata.ui.components.homapage
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.trashure.ui.components.homepage.SectionText

@Composable
fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionText(title, modifier)
        content()
    }
}