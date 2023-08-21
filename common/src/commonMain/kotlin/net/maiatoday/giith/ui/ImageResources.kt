package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@Composable
expect fun imageResource(image: String): ImageBitmap

@OptIn(ExperimentalResourceApi::class)
@Composable
fun imageResourcePainter(image: String): Painter = painterResource("drawable/$image")
