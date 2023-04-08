package net.maiatoday.giith.ui

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter

expect fun imageResourcePainter(image: String): Painter
expect fun imageResource(image: String): ImageBitmap