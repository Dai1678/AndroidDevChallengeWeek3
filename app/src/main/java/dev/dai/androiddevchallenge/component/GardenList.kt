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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dev.dai.androiddevchallenge.R
import dev.dai.androiddevchallenge.data.Garden
import dev.dai.androiddevchallenge.data.gardenList
import dev.dai.androiddevchallenge.ui.theme.MyTheme
import dev.dai.androiddevchallenge.ui.theme.gray

@Composable
fun GardenList() {
    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        gardenList.forEach {
            GardenItem(it)
        }
    }
}

@Composable
fun GardenItem(garden: Garden) {
    ConstraintLayout(modifier = Modifier.height(64.dp)) {
        val (image, name, description, checkbox, divider) = createRefs()

        Image(
            painter = painterResource(garden.imageResId),
            contentDescription = garden.name,
            modifier = Modifier
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
                .width(64.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.Crop
        )
        Text(
            text = garden.name,
            color = gray,
            style = MaterialTheme.typography.h2,
            modifier = Modifier
                .constrainAs(name) {
                    top.linkTo(parent.top)
                    start.linkTo(image.end, margin = 16.dp)
                }
                .paddingFromBaseline(24.dp)
        )
        Text(
            text = garden.description,
            color = gray,
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .constrainAs(description) {
                    top.linkTo(name.bottom)
                    start.linkTo(name.start)
                }
                .paddingFromBaseline(bottom = 24.dp)
        )
        Checkbox(
            checked = true,
            onCheckedChange = { /*TODO*/ },
            modifier = Modifier.constrainAs(checkbox) {
                end.linkTo(parent.end, margin = 16.dp)
                top.linkTo(parent.top, margin = 16.dp)
            }
        )
        Divider(
            modifier = Modifier.constrainAs(divider) {
                top.linkTo(description.bottom)
                start.linkTo(image.end, margin = 8.dp)
                end.linkTo(checkbox.end)
            }
        )
    }
}

@Preview
@Composable
fun GardenItemPreview() {
    MyTheme {
        Surface {
            GardenItem(Garden(R.drawable.monstera, "Mostera"))
        }
    }
}
