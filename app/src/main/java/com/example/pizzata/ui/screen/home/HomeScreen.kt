package com.example.pizzata.ui.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pizzata.R
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.unit.sp
import com.example.pizzata.model.ActivityNews
import com.example.pizzata.model.Category
import com.example.pizzata.model.Menu
import com.example.pizzata.model.dummyActivity
import com.example.pizzata.model.dummyCategory
import com.example.pizzata.model.dummyMenu
import com.example.pizzata.ui.components.homapage.BannerSlider
import com.example.pizzata.ui.components.homapage.CardActivityViews
import com.example.pizzata.ui.components.homapage.CardCategoryViews
import com.example.pizzata.ui.components.homapage.CardMenuFavViews
import com.example.pizzata.ui.components.homapage.CategoryItem
import com.example.pizzata.ui.components.homapage.HomeSection
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.ui.theme.PrimaryColor

//import com.example.trashure.di.Injection
//import com.example.trashure.model.*
//import com.example.trashure.ui.common.UiState
//import com.example.trashure.ui.components.homepage.*
//import com.example.trashure.ui.theme.Blue_1
//import com.example.trashure.ui.theme.Green_1
//import com.example.trashure.ui.theme.PrimaryBackgroundColor
//import com.example.trashure.ui.theme.TrashureTheme
//import com.example.trashure.utils.ViewModelFactory

//@Composable
//fun HomeScreen(
//    navigateToMarketPlace : () -> Unit,
//    navigateToSellPage : () -> Unit,
//    navigateToDetail: (Long) -> Unit,
//    viewModel: HomeViewModel = viewModel(
//        factory = ViewModelFactory(Injection.provideRepository(context = LocalContext.current))
//    )
//){
//    viewModel.newsState.collectAsState(initial = UiState.Loading).value.let { uiState ->
//        when(uiState){
//            is UiState.Loading -> {
//                viewModel.getAllNews()
//            }
//            is UiState.Success -> {
//                HomeScreenContent(
//                    navigateToMarketPlace = navigateToMarketPlace,
//                    navigateToSellPage = navigateToSellPage,
//                    navigateToDetail = navigateToDetail
//                )
//            }
//            is UiState.Error -> {}
//            else -> {
//
//            }
//        }
//
//    }
//}

@Composable
fun HomeScreenContent(
    navigateToMenu: () -> Unit,
    modifier: Modifier = Modifier,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        BannerSlider()
        CategoryRow(dummyCategory )
        Category(
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        )
        HomeSection(
            title = stringResource(R.string.favmenu_title),
            content = { MenuCategory(dummyMenu, navigateToMenu) }
        )
        HomeSection(
            title = stringResource(R.string.most_popular),
            content = { ActivityCategory(dummyActivity) },
            modifier = modifier
                .padding(top = 10.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun HomeScreenPreview() {
    PizzaTATheme {
        HomeScreenContent({})
    }
}

@Composable
fun BannerHome(
    username: String,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier
        .fillMaxWidth()
    ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Row {
                    Text(
                        text = "Hello, $username",
                        maxLines = 1,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.wavinghand),
                        contentDescription = "null",
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
                Text(
                    text = "Sudah kamu membuang sampah?",
                    maxLines = 1,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun TextPreview() {
    PizzaTATheme {
        BannerHome("Hilalhmdy")
    }
}

@Composable
fun MenuCategory(
    listNews: List<Menu>,
    navigateToMenu: () -> Unit,
    modifier: Modifier = Modifier,
    ) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 26.dp),
        modifier = modifier
            .padding(top = 10.dp)
    ) {
        items(listNews) { menu ->
            CardMenuFavViews(
                image = menu.image,
                title = menu.title,
                price = menu.price,
                modifier = Modifier
                    .clickable {
                        navigateToMenu()
                    }
            )
        }
    }
}

@Composable
fun ActivityCategory(
    listActivity: List<ActivityNews>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 26.dp),
        modifier = modifier
            .padding(top = 10.dp)
    ) {
        items(listActivity) { activity ->
            CardActivityViews(
                id = activity.id,
                image = activity.image
            )
        }
    }
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
fun Category(
    modifier: Modifier = Modifier
){
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
    ) {
        CardCategoryViews(
            icon = R.drawable.pizza,
            title = stringResource(R.string.saldo),
            input = 30000
        )
        CardCategoryViews(
            icon = R.drawable.pizza,
            title = stringResource(R.string.poin),
            input = 3000
        )
    }
}

