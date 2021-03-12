package dev.dai.androiddevchallenge.navigation

sealed class Screen(val route: String) {
    object Screen1 : Screen("Screen1")
    object Screen2: Screen("Screen2")
}
