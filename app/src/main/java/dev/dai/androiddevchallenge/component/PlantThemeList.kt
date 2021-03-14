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
package dev.dai.androiddevchallenge.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.androiddevchallenge.R
import dev.dai.androiddevchallenge.data.PlantTheme
import dev.dai.androiddevchallenge.data.plantThemeList
import dev.dai.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PlantThemeList(modifier: Modifier = Modifier) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            modifier = modifier.paddingFromBaseline(bottom = 16.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(plantThemeList) {
                PlantThemeItem(it)
            }
        }
    }
}

@Composable
fun PlantThemeItem(plantTheme: PlantTheme) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp
    ) {
        Column {
            Image(
                painter = painterResource(plantTheme.imageResId),
                contentDescription = plantTheme.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 136.dp, height = 96.dp)
            )
            Text(
                text = plantTheme.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PlantThemeListPreview() {
    MyTheme {
        Surface {
            PlantThemeList()
        }
    }
}

@Preview
@Composable
fun PlantThemeItemPreview() {
    MyTheme {
        Surface {
            PlantThemeItem(
                PlantTheme(
                    R.drawable.desert_chic,
                    "Desert Chic"
                )
            )
        }
    }
}
