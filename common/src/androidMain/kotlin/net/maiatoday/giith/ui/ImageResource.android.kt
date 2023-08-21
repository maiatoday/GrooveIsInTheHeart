package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource

@Composable
actual fun imageResource(image: String): ImageBitmap {
    val context = LocalContext.current
    val name = image.substringBefore(".")
    val drawable = context.resources.getIdentifier(name, "drawable", context.packageName)
    return ImageBitmap.imageResource(drawable)
}