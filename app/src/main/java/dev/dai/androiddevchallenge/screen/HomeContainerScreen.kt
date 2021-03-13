/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.dai.androiddevchallenge.screen

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
import dev.dai.androiddevchallenge.navigation.HomeScreen
import dev.dai.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeContainerScreen() {
    val navController = rememberNavController()
    MyTheme {
        Scaffold(
            bottomBar = {
                BottomNavigation(
                    Modifier.navigationBarsHeight(additional = 56.dp),
                    backgroundColor = MaterialTheme.colors.primary
                ) {
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
                            icon = {
                                Icon(
                                    imageVector = screen.iconVector,
                                    contentDescription = screen.route
                                )
                            },
                            label = {
                                Text(
                                    text = stringResource(screen.resId),
                                    style = MaterialTheme.typography.caption
                                )
                            },
                            selected = currentRoute == screen.route,
                            onClick = {
                                navController.navigate(screen.route) {
                                    launchSingleTop = true
                                }
                            },
                            modifier = Modifier.navigationBarsPadding()
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
