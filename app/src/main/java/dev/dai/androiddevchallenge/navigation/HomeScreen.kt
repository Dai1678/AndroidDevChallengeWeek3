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
package dev.dai.androiddevchallenge.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector
import dev.dai.androiddevchallenge.R

sealed class HomeScreen(val route: String, @StringRes val resId: Int, val iconVector: ImageVector) {
    object Home : HomeScreen("home", R.string.home, Icons.Default.Home)
    object Favorites : HomeScreen("favorites", R.string.favorites, Icons.Default.FavoriteBorder)
    object Profile : HomeScreen("profile", R.string.profile, Icons.Default.AccountCircle)
    object Cart : HomeScreen("cart", R.string.cart, Icons.Default.ShoppingCart)
}
