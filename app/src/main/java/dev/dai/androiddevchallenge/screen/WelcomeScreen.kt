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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.androiddevchallenge.R
import dev.dai.androiddevchallenge.navigation.Screen
import dev.dai.androiddevchallenge.ui.theme.MyTheme
import dev.dai.androiddevchallenge.ui.theme.gray
import dev.dai.androiddevchallenge.ui.theme.pink900
import dev.dai.androiddevchallenge.ui.theme.white

@Composable
fun WelcomeScreen(navHostController: NavHostController) {
    MyTheme {
        Surface(
            color = MaterialTheme.colors.primary,
            modifier = Modifier.fillMaxSize()
        ) {
            Box {
                Image(
                    painter = painterResource(id = R.drawable.ic_light_welcome_bg),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                )
                Column {
                    Image(
                        painter = painterResource(id = R.drawable.ic_light_welcome_illos),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 72.dp, start = 88.dp, bottom = 48.dp)
                    )
                    Text(
                        text = "Bloom",
                        Modifier.align(Alignment.CenterHorizontally),
                        fontSize = 48.sp
                    )
                    Text(
                        text = "Beautiful home garden solutions",
                        color = gray,
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .paddingFromBaseline(top = 32.dp, bottom = 40.dp),
                        style = MaterialTheme.typography.subtitle1
                    )
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = pink900
                        ),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .padding(bottom = 8.dp, start = 16.dp, end = 16.dp)
                            .fillMaxWidth()
                            .height(48.dp)
                            .align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Create account",
                            color = white,
                            style = MaterialTheme.typography.button
                        )
                    }
                    TextButton(
                        onClick = { navHostController.navigate(Screen.LoginScreen.route) },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Text(
                            text = "Log in",
                            color = pink900,
                            style = MaterialTheme.typography.button
                        )
                    }
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
