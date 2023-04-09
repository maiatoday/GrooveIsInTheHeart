package net.maiatoday.giith.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PinkClouds() {
    val pinkClouds = imageResourcePainter("pinkclouds.jpg")
    Image(
        painter = pinkClouds,
        contentDescription = "pink clouds"
    )
}

@Composable
fun BlueStars() {
    val blueStars = imageResourcePainter("bluestars.jpg")
    Image(
        painter = blueStars,
        contentDescription = "blue Stars"
    )
}

@Composable
fun UltraViolet() {
    val ultraViolet = imageResourcePainter("ultraviolet.jpg")
    Image(
        painter = ultraViolet,
        contentDescription = "ultra Violet"
    )
}

@Composable
fun Bork(size: Dp = 100.dp) {
    val bork = imageResourcePainter("bork.png")
    Image(
        modifier = Modifier.size(size),
        painter = bork,
        contentDescription = "Broken File"
    )
}

@Composable
fun UltraVioletBox(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    val image: ImageBitmap = imageResource("ultraviolet.jpg")
    val brush = remember(image) { ShaderBrush(ImageShader(image, TileMode.Repeated, TileMode.Repeated)) }
    Box(
        modifier
            .fillMaxSize()
            .background(brush),
        content = content
    )
}

@Composable
fun BlueStarsBox(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    val image: ImageBitmap = imageResource("bluestars.jpg")
    val brush = remember(image) { ShaderBrush(ImageShader(image, TileMode.Repeated, TileMode.Repeated)) }
    Box(
        modifier
            .fillMaxSize()
            .background(brush),
        content = content
    )
}

@Composable
fun PinkCloudsBox(modifier: Modifier = Modifier, content: @Composable BoxScope.() -> Unit) {
    val image: ImageBitmap = imageResource("pinkclouds.jpg")
    val brush = remember(image) { ShaderBrush(ImageShader(image, TileMode.Repeated, TileMode.Repeated)) }
    Box(
        modifier
            .fillMaxSize()
            .background(brush),
        content = content
    )
}