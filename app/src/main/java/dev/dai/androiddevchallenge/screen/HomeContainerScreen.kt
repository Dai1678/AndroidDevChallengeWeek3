package dev.dai.androiddevchallenge.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.androiddevchallenge.navigation.HomeScreen
import dev.dai.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeContainerScreen() {
    val navController = rememberNavController()
    MyTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation {
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                    val navigationItems = listOf(
                        HomeScreen.Home,
                        HomeScreen.Favorites,
                        HomeScreen.Profile,
                        HomeScreen.Cart
                    )
                    navigationItems.forEach { screen ->
                        BottomNavigationItem(
                            icon = { Icon(imageVector = screen.iconVector, contentDescription = screen.route) },
                            label = { Text(stringResource(screen.resId)) },
                            selected = currentRoute == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
                                    launchSingleTop = true
                                }
                            }
                        )
                    }
                }
            }
        ) {
            NavHost(navController = navController, startDestination = HomeScreen.Home.route) {
                composable(HomeScreen.Home.route) {
                    HomeScreen()
                }
                composable(HomeScreen.Favorites.route) {

                }
                composable(HomeScreen.Profile.route) {

                }
                composable(HomeScreen.Cart.route) {

                }
            }
        }
    }
}
