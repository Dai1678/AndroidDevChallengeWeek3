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
package dev.dai.androiddevchallenge.data

import androidx.annotation.DrawableRes
import dev.dai.androiddevchallenge.R

data class Garden(
    @DrawableRes val imageResId: Int,
    val name: String,
    val description: String = "This is a description"
)

val gardenList = listOf(
    Garden(R.drawable.monstera, "Monstera"),
    Garden(R.drawable.aglaonema, "Aglaonema"),
    Garden(R.drawable.peace_lily, "Peace Lily"),
    Garden(R.drawable.fiddle_leaf, "Fiddle leaf tree"),
    Garden(R.drawable.snake_plant, "Snake plant"),
    Garden(R.drawable.pothos, "Pothos")
)
