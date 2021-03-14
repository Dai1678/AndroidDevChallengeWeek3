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
package dev.dai.bloom

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.dai.bloom.navigation.MainScreen
import dev.dai.bloom.screen.HomeContainerScreen
import dev.dai.bloom.screen.LoginScreen
import dev.dai.bloom.screen.WelcomeScreen
import dev.dai.bloom.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ProvideWindowInsets {
                MyTheme {
                    WindowCompat.getInsetsController(
                        window, window.decorView
                    )?.isAppearanceLightStatusBars = MaterialTheme.colors.isLight
                    MyApp()
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = MainScreen.Welcome.route) {
        composable(MainScreen.Welcome.route) {
            WelcomeScreen(navController)
        }
        composable(MainScreen.Login.route) {
            LoginScreen(navController)
        }
        composable(MainScreen.HomeContainer.route) {
            HomeContainerScreen()
        }
    }
}
