package com.example.pizzata

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Article
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pizzata.ui.navigation.Screen
import com.example.pizzata.ui.screen.home.HomeScreenContent
import com.example.pizzata.ui.theme.PizzaTATheme
import com.example.pizzata.ui.theme.PrimaryBackgroundColor
import com.example.pizzata.ui.theme.PrimaryColor
import com.example.pizzata.ui.navigation.NavigationItem

@Composable
fun PizzaApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
){
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val screenWithoutBottomBar: List<String?> =
        listOf(
//            Screen.Splash1.route,
//            Screen.Splash2.route,
            Screen.Login.route,
            Screen.Register.route,
            Screen.EditProfile.route,
            Screen.ChangePassword.route,
            Screen.TrashureMarket.route,
            Screen.MarketPage.route,
            Screen.UMKMMarket.route,
            Screen.SellPage.route,
            Screen.DetailNews.route,
            Screen.ScanPage.route
        )
    Scaffold(
        bottomBar = {
            if(!(screenWithoutBottomBar).contains(currentRoute)){
                BottomBar(navController)
            }
        },
        floatingActionButton = {
            if(!(screenWithoutBottomBar).contains(currentRoute)){
                MyUI(
                    navigateToScan = {
                        navController.navigate(Screen.ScanPage.route)
                    }
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ){
            composable(Screen.Home.route){
                HomeScreenContent(
                    navigateToMenu = {
                        navController.navigate(Screen.Menu.route)
                    }
                )
            }
        }
    }
}

@Composable
fun BottomBar(
    navController: NavHostController,
    modifier : Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = Color.Black,
        elevation = 10.dp,
        modifier = modifier
            .fillMaxWidth()
            .graphicsLayer {
                clip = true
                shape = RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp)
                shadowElevation = 20f
            }
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val navigationItems = listOf(
            NavigationItem(
                title = "Home",
                icon = Icons.Default.Home,
                screen = Screen.Home
            ),
            NavigationItem(
                title = "Order",
                icon = Icons.Default.Article,
                screen = Screen.Order
            ),
            NavigationItem(
                title = "",
                icon = Icons.Default.Person,
                screen = Screen.ScanPage
            ),
            NavigationItem(
                title = "Inbox",
                icon = Icons.Default.Email,
                screen = Screen.Inbox
            ),
            NavigationItem(
                title = "Profile",
                icon = Icons.Default.Person,
                screen = Screen.Profile
            ),
        )
        BottomNavigation(
            backgroundColor = PrimaryBackgroundColor
        ) {
            navigationItems.map { item ->
                BottomNavigationItem(
                    icon = {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title + "_page"
                        )
                    },
                    label = {
                        Text(item.title)
                    },
                    selected = currentRoute == item.screen.route,
                    onClick = {
                        navController.navigate(item.screen.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            restoreState = true
                            launchSingleTop = true
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun MyUI(
    navigateToScan : () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()){
        FloatingActionButton(
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
                .padding(all = 0.dp)
                .offset(x = 18.dp, y = 60.dp)
                .size(70.dp),
            onClick = {
                navigateToScan()
            },
            backgroundColor = PrimaryColor
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.upcscan),
                    contentDescription = "Add",
                    tint = Color.White
                )
                Text(
                    text = "Scan",
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomPreview() {
    PizzaTATheme{
        PizzaApp()
    }
}
