package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter

@Composable
expect fun imageResourcePainter(image: String): Painter

@Composable
expect fun imageResource(image: String): ImageBitmap