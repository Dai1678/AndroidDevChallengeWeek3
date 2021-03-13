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
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.dai.androiddevchallenge.R
import dev.dai.androiddevchallenge.data.Garden
import dev.dai.androiddevchallenge.data.gardenList
import dev.dai.androiddevchallenge.ui.theme.MyTheme
import dev.dai.androiddevchallenge.ui.theme.gray

@Composable
fun PlantList(modifier: Modifier = Modifier) {
    Column(Modifier.padding(horizontal = 16.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .paddingFromBaseline(bottom = 16.dp)
        ) {
            Text(
                text = "Design your home garden",
                style = MaterialTheme.typography.h1,
                modifier = Modifier.weight(1f)
            )
            IconButton(
                onClick = { },
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = null
                )
            }
        }
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            gardenList.forEach {
                PlantItem(it)
            }
        }
    }
}

@Composable
fun PlantItem(garden: Garden) {
    var checked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(garden.imageResId),
            contentDescription = garden.name,
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier.height(64.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp)
                ) {
                    Text(
                        text = garden.name,
                        color = gray,
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = garden.description,
                        color = gray,
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(bottom = 24.dp)
                    )
                }
                Checkbox(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(bottom = 24.dp)
                )
            }
            Divider(modifier = Modifier.padding(start = 8.dp))
        }
    }
}

@Preview
@Composable
fun PlantListPreview() {
    MyTheme {
        Surface {
            PlantList()
        }
    }
}

@Preview
@Composable
fun PlantItemPreview() {
    MyTheme {
        Surface {
            PlantItem(Garden(R.drawable.monstera, "Mostera"))
        }
    }
}
