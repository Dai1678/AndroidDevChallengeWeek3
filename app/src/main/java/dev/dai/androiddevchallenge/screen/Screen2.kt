package dev.dai.androiddevchallenge.screen

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dev.dai.androiddevchallenge.ui.theme.MyTheme

@Composable
fun Screen2(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Screen2") },
                navigationIcon = {
                    IconButton(onClick = navHostController::navigateUp) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        Text(text = "This is Screen2")
    }
}

@Preview
@Composable
fun Screen2Preview() {
    MyTheme {
        Screen2(navHostController = rememberNavController())
    }
}
