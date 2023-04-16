package net.maiatoday.giith.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
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
fun Inky(size: Dp = 100.dp) {
    val bork = imageResourcePainter("inky.png")
    Image(
        modifier = Modifier.size(size),
        painter = bork,
        contentDescription = "Inky"
    )
}

@Composable
fun Pinky(size: Dp = 100.dp) {
    val bork = imageResourcePainter("pinky.png")
    Image(
        modifier = Modifier.size(size),
        painter = bork,
        contentDescription = "Pinky"
    )
}

@Composable
fun Blinky(size: Dp = 100.dp) {
    val bork = imageResourcePainter("blinky.png")
    Image(
        modifier = Modifier.size(size),
        painter = bork,
        contentDescription = "Blinky"
    )
}

@Composable
fun VulnerableGhost(modifier:Modifier = Modifier, size: Dp = 100.dp) {
    val bork = imageResourcePainter("ghost.png")
    Image(
        modifier = modifier.size(size),
        painter = bork,
        contentDescription = "Ghost"
    )
}

@Composable
fun Clyde(size: Dp = 100.dp) {
    val bork = imageResourcePainter("clyde.png")
    Image(
        modifier = Modifier.size(size),
        painter = bork,
        contentDescription = "Clyde"
    )
}

@Composable
fun ComposeLogo(size: Dp = 100.dp) {
    val infiniteTransition = rememberInfiniteTransition()
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(2000, easing = LinearEasing)
        )
    )
    val compose = imageResourcePainter("compose.png")
    Image(
        modifier = Modifier.size(size).rotate(angle),
        painter = compose,
        contentDescription = "Compose"
    )
}

@Composable
fun TheAiHelpedMe(size: Dp = 100.dp) {
    val bork = imageResourcePainter("aihelp.png")
    Image(
        modifier = Modifier.size(size),
        painter = bork,
        contentDescription = "chatgpt"
    )
}
