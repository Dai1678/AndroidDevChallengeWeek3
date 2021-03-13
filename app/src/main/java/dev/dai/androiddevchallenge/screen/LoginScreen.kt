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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.androiddevchallenge.navigation.MainScreen
import dev.dai.androiddevchallenge.ui.theme.MyTheme
import dev.dai.androiddevchallenge.ui.theme.gray
import dev.dai.androiddevchallenge.ui.theme.pink900
import dev.dai.androiddevchallenge.ui.theme.white

@Composable
fun LoginScreen(navHostController: NavHostController) {
    MyTheme {
        Surface(
            color = MaterialTheme.colors.background,
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Log in with email",
                    color = gray,
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .paddingFromBaseline(top = 184.dp, bottom = 16.dp)
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = { /*TODO*/ },
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth()
                        .height(56.dp),
                    placeholder = {
                        Text(
                            text = "Email address",
                            color = gray,
                            style = MaterialTheme.typography.body1
                        )
                    }
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    placeholder = {
                        Text(
                            text = "Password (8+ characters)",
                            color = gray,
                            style = MaterialTheme.typography.body1
                        )
                    }
                )
                Text(
                    text = " By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
                    color = gray,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier
                        .paddingFromBaseline(top = 24.dp, bottom = 16.dp),
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = { navHostController.navigate(MainScreen.HomeContainer.route) },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = pink900
                    ),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(
                        text = "Log in",
                        color = white,
                        style = MaterialTheme.typography.button
                    )
                }
            }
        }
    }
}

@Preview("Login Screen", widthDp = 360, heightDp = 640)
@Composable
fun LoginScreenPreview() {
    MyTheme {
        LoginScreen(navHostController = rememberNavController())
    }
}
