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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.androiddevchallenge.component.GardenList
import dev.dai.androiddevchallenge.component.GardenThemeList
import dev.dai.androiddevchallenge.ui.theme.MyTheme
import dev.dai.androiddevchallenge.ui.theme.gray

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(40.dp))
        OutlinedTextField(
            value = "",
            onValueChange = { /*TODO*/ },
            readOnly = true,
            modifier = Modifier
                .height(56.dp)
                .fillMaxWidth(),
            label = {
                Text(
                    text = "Search",
                    color = gray,
                    style = MaterialTheme.typography.body1
                )
            },
            textStyle = MaterialTheme.typography.body1,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(18.dp)
                )
            }
        )
        Text(
            text = "Browse themes",
            color = gray,
            style = MaterialTheme.typography.h1,
            modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 16.dp)
        )
        GardenThemeList()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Design your home garden",
                color = gray,
                style = MaterialTheme.typography.h1
            )
            Image(
                imageVector = Icons.Default.FilterList,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically),
            )
        }
        GardenList()
    }
}

@Preview("Home Screen", widthDp = 360, heightDp = 680)
@Composable
fun HomeScreenPreview() {
    MyTheme {
        Surface {
            HomeScreen()
        }
    }
}
