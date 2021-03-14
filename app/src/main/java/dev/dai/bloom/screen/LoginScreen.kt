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

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.dai.bloom.component.ClickableLinkText
import dev.dai.bloom.navigation.MainScreen
import dev.dai.bloom.ui.theme.MyTheme

@Composable
fun LoginScreen(navHostController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
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
                style = MaterialTheme.typography.h1,
                modifier = Modifier
                    .paddingFromBaseline(top = 184.dp, bottom = 16.dp)
            )
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                label = {
                    Text(
                        text = "Email address",
                        style = MaterialTheme.typography.body1
                    )
                }
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(
                        text = "Password (8+ characters)",
                        style = MaterialTheme.typography.body1
                    )
                },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            ClickableLinkText(
                text = " By clicking below, you agree to our Terms of Use and consent to our Privacy Policy.",
                links = listOf(
                    "Terms of Use",
                    "Privacy Policy"
                ),
                textStyle = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 16.dp)
            )
            Button(
                onClick = { navHostController.navigate(MainScreen.HomeContainer.route) },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                ),
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(
                    text = "Log in",
                    style = MaterialTheme.typography.button
                )
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
