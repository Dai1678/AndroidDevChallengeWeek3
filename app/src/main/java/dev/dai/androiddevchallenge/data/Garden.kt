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
