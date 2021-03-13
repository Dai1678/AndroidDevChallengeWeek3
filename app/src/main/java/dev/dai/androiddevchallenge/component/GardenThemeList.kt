package dev.dai.androiddevchallenge.component

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import dev.dai.androiddevchallenge.data.GardenTheme
import dev.dai.androiddevchallenge.data.gardenThemeList
import dev.dai.androiddevchallenge.ui.theme.MyTheme
import dev.dai.androiddevchallenge.ui.theme.gray

@Composable
fun GardenThemeList() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(gardenThemeList) {
            GardenThemeItem(it)
        }
    }
}


@Composable
fun GardenThemeItem(gardenTheme: GardenTheme) {
    Card(
        shape = MaterialTheme.shapes.small,
        elevation = 1.dp
    ) {
        Column {
            Image(
                painter = painterResource(gardenTheme.imageResId),
                contentDescription = gardenTheme.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(width = 136.dp, height = 96.dp)
            )
            Text(
                text = gardenTheme.name,
                color = gray,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun GardenThemeItemPreview() {
    MyTheme {
        Surface {
            GardenThemeItem(gardenTheme = GardenTheme(R.drawable.desert_chic, "Desert Chic"))
        }
    }
}
