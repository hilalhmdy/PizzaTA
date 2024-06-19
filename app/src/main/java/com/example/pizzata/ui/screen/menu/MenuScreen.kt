package com.example.pizzata.ui.screen.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.model.Category
import com.example.pizzata.model.Menu
import com.example.pizzata.model.dummyCategory
import com.example.pizzata.model.dummyMenu
import com.example.pizzata.ui.components.homapage.CategoryItem
import com.example.pizzata.ui.components.menu.CardMenuOrder
import com.example.pizzata.ui.theme.PizzaTATheme

//@Composable
//fun MenuScreenContent(
//    navigateBack: () -> Unit,
//    modifier: Modifier = Modifier,
//){
//    Scaffold(
//        topBar = {
//            TopBarMenuOrder(
//                navigateBack = navigateBack ,
//                title = "Menu"
//            )
//
//        }
//    ) {innerPadding ->
//        Column(
//            verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            modifier = modifier
//                .verticalScroll(rememberScrollState())
//                .padding(innerPadding)
//                .fillMaxSize()
//        ){
//            CategoryRow(
//                dummyCategory
//            )
//            Spacer(modifier = Modifier.height(20.dp))
//            ListCardMenu(
//                dummyMenu
//            )
//        }
//    }
//}

@Composable
fun MenuScreenContent(
    navigateBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopBarMenuOrder(
                navigateBack = navigateBack,
                title = "Menu"
            )
        }
    ) { innerPadding ->
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            contentPadding = innerPadding,
            modifier = modifier.fillMaxSize()
        ) {
            item {
                CategoryRow(
                    listCategory = dummyCategory,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            items(dummyMenu) { data ->
                CardMenuOrder(
                    image = data.image,
                    title = data.title,
                    price = data.price,
                    describe = data.describe,
                    onClick = {}
                )
            }
        }
    }
}

@Composable
fun TopBarMenuOrder(
    navigateBack: () -> Unit,
    title : String,
    modifier: Modifier = Modifier,
){
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                navigateBack()
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Menu",
                    tint = Color(0xFF1A395A)
                )
            }
        },
        backgroundColor = Color.White,
        title = {
            Text(
                text = title,
                color = Color(0xFF1A395A),
                textAlign = TextAlign.Center,
                modifier = modifier
                    .padding(start = 60.dp)
            )
        },
        actions = {},
        elevation = 0.dp,
    )
}

@Composable
fun CategoryRow(
    listCategory: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
            .padding(top= 12.dp , start = 6.dp)
    ) {
        items(listCategory) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun ListCardMenu(
    listOrderProgress: List<Menu>,
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
        items(listOrderProgress){data ->
            CardMenuOrder(
                image = data.image,
                title = data.title,
                price = data.price,
                describe = data.describe,
                onClick = {}
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuScreenPreview(){
    PizzaTATheme {
        MenuScreenContent({})
    }
}