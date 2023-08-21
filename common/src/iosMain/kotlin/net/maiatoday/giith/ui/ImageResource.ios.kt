package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.skia.Image

//TODO this will totally not work, just getting it to build
@Composable
actual fun imageResource(image: String): ImageBitmap = Image.makeFromEncoded(ByteArray(0)).toComposeImageBitmap()