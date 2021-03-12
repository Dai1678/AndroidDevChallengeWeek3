package dev.dai.androiddevchallenge.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.androiddevchallenge.navigation.Screen
import dev.dai.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Screen1(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen1") }
            )
        }
    ) {
        Column {
            Text(text = "This is Screen1")
            Button(
                onClick = { navHostController.navigate(Screen.Screen2.route) }
            ) {
                Text(text = "Go to Screen2")
            }
        }
    }
}

@Preview
@Composable
fun Screen1Preview() {
    MyTheme {
        Screen1(navHostController = rememberNavController())
    }
}
