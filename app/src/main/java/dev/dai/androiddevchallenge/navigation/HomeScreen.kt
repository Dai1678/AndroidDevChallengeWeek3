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