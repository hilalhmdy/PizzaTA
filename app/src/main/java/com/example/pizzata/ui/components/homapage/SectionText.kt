package com.example.trashure.ui.components.homepage

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.ui.theme.PizzaTATheme

@Composable
fun SectionText(
    title: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        color = Color(0xFF1A395A),
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = modifier
            .padding(horizontal = 26.dp, vertical = 8.dp)
    )
}

@Composable
@Preview(showBackground = true)
fun TextPreview() {
    PizzaTATheme {
        SectionText(
            "Activity"
        )
    }
}
