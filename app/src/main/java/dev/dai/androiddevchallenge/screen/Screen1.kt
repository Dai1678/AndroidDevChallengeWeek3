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
