package dev.dai.androiddevchallenge.screen

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.dai.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen() {
    MyTheme {
        Scaffold(
            bottomBar = {

            }
        ) {

        }
    }
}

@Preview("Home Screen", widthDp = 360, heightDp = 640)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
