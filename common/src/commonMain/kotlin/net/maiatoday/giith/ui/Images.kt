package net.maiatoday.giith.ui

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable

@Composable
fun PinkClouds() {
    val pinkClouds = imageResource("pinkclouds.jpg")
    Image(
        painter = pinkClouds,
        contentDescription = "pink clouds"
    )
}

@Composable
fun BlueStars() {
    val blueStars = imageResource("bluestars.jpg")
    Image(
        painter = blueStars,
        contentDescription = "blue Stars"
    )
}

@Composable
fun UltraViolet() {
    val ultraViolet = imageResource("ultraviolet.jpg")
    Image(
        painter = ultraViolet,
        contentDescription = "ultra Violet"
    )
}