package com.example.pizzata.ui.screen.inbox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.model.dummyMessage
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.model.Message
import com.example.pizzata.ui.components.inboxpage.CardInboxViews

@Composable
fun InboxScreenContent(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            InboxTopBar(title = "Kotak Masuk")
        },
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            ListMessage(dummyMessage)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InboxScreenPreview(){
    PizzaTATheme {
        InboxScreenContent()
    }
}

@Composable
fun InboxTopBar(
    title : String,
    modifier : Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = Color(0xFF1A395A),
                modifier = modifier
                    .padding(start = 16.dp)
            )
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )
}

@Preview
@Composable
fun OrderTopBarPreview(){
    PizzaTATheme {
        InboxTopBar( "Kotak Masuk")
    }
}

@Composable
fun ListMessage(
    listMessage: List<Message>,
    modifier: Modifier = Modifier
){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
    ){
        items(listMessage){data ->
            CardInboxViews(
                title = data.title ,
                description = data.description )
        }

    }
}