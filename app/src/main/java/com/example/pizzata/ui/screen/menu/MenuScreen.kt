package com.example.pizzata.ui.screen.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pizzata.model.Category
import com.example.pizzata.model.Menu
import com.example.pizzata.model.dummyCategory
import com.example.pizzata.model.dummyMenu
import com.example.pizzata.ui.components.homapage.CategoryItem
import com.example.pizzata.ui.components.menu.CardMenuOrder
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.ui.theme.PrimaryColor
import com.example.pizzata.ui.theme.Shapes


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
        },
        bottomBar = {
                    BottomButton()
        },
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarMenuOrder(
    navigateBack: () -> Unit,
    title : String,
    modifier: Modifier = Modifier,
){
    var expanded = remember { mutableStateOf(false) }
    var selectedFilter = remember { mutableStateOf("Dine In") }

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
        actions = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .clickable { expanded.value = true }
            ) {
                Text(text = selectedFilter.value, color = Color(0xFF1A395A))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "Filter",
                    tint = PrimaryColor,
                    modifier = Modifier.size(20.dp)
                )
            }
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false },
                modifier = Modifier.background(Color.White)
            ) {
                DropdownMenuItem(onClick = {
                    selectedFilter.value = "Dine In"
                    expanded.value = false
                }) {
                    Text("Dine In")
                }
                DropdownMenuItem(onClick = {
                    selectedFilter.value = "Take Away"
                    expanded.value = false
                }) {
                    Text("Take Away")
                }
                DropdownMenuItem(onClick = {
                    selectedFilter.value = "Delivery"
                    expanded.value = false
                }) {
                    Text("Delivery")
                }
            }
        },
        elevation = 0.dp,
    )
}

@Composable
fun CategoryRow(
    listCategory: List<Category>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
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
fun BottomButton() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color.White)
            .shadow(
                elevation = 1.dp,
                shape = RectangleShape,
                ambientColor = Color(0x3A000000),
                spotColor = Color(0x3A000000),
            ),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = { /* Handle click */ },
            shape = Shapes.medium,
            colors = ButtonDefaults.buttonColors(PrimaryColor),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 26.dp, )
        ) {
            Text("Add to Cart",
                color = Color.White,
                fontSize = 16.sp
            )
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