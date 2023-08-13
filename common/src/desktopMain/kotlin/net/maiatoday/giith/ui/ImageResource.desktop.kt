package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource

@Composable
actual fun imageResourcePainter(image: String): Painter = painterResource("drawable/$image")

@Composable
actual fun imageResource(image: String): ImageBitmap = useResource("drawable/$image", ::loadImageBitmap)
