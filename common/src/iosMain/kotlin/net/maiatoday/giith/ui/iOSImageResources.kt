package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap


@Composable
actual fun imageResourcex(image: String): ImageBitmap = useResource("drawable/$image", ::loadImageBitmap)