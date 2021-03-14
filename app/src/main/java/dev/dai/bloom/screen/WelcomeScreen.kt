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
package dev.dai.bloom.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.bloom.R
import dev.dai.bloom.navigation.MainScreen
import dev.dai.bloom.ui.theme.MyTheme
import dev.dai.bloom.ui.theme.pink900
import dev.dai.bloom.ui.theme.white

@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    val isLightTheme = MaterialTheme.colors.isLight
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier.fillMaxSize()
    ) {
        Box {
            Image(
                painter = painterResource(
                    id = if (isLightTheme) {
                        R.drawable.ic_light_welcome_bg
                    } else {
                        R.drawable.ic_dark_welcome_bg
                    }
                ),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(
                        id = if (isLightTheme) {
                            R.drawable.ic_light_welcome_illos
                        } else {
                            R.drawable.ic_dark_welcome_illos
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(top = 72.dp, bottom = 48.dp)
                        .align(Alignment.Start)
                        .offset(x = 88.dp)
                )
                Image(
                    painter = painterResource(
                        id = if (isLightTheme) {
                            R.drawable.ic_light_logo
                        } else {
                            R.drawable.ic_dark_logo
                        }
                    ),
                    contentDescription = null
                )
                Text(
                    text = "Beautiful home garden solutions",
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                    style = MaterialTheme.typography.subtitle1
                )
                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = MaterialTheme.colors.secondary
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Create account",
                        style = MaterialTheme.typography.button
                    )
                }
                TextButton(
                    onClick = { navHostController.navigate(MainScreen.Login.route) }
                ) {
                    Text(
                        text = "Log in",
                        color = if (isLightTheme) pink900 else white,
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}

@Preview("Welcome Screen", widthDp = 360, heightDp = 640)
@Composable
fun WelcomeScreenPreview() {
    MyTheme {
        WelcomeScreen(navHostController = rememberNavController())
    }
}
