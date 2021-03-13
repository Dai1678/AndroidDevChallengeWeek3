package dev.dai.androiddevchallenge.data

import androidx.annotation.DrawableRes
import dev.dai.androiddevchallenge.R

data class GardenTheme(
    @DrawableRes val imageResId: Int,
    val name: String
)

val gardenThemeList = listOf(
    GardenTheme(R.drawable.desert_chic, "Desert chic"),
    GardenTheme(R.drawable.tiny_terrariums, "Tiny terrariums"),
    GardenTheme(R.drawable.jungle_vibes, "Jungle vibes"),
    GardenTheme(R.drawable.easy_care, "Easy care"),
    GardenTheme(R.drawable.statements, "Statements")
)
