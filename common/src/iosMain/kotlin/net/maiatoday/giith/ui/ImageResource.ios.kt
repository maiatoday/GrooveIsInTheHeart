package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.toComposeImageBitmap
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.skia.Image

//TODO the path will be wrong
@OptIn(ExperimentalResourceApi::class)
@Composable
actual fun imageResourcePainter(image: String): Painter = painterResource(image)

//TODO this will totally not work, just getting it to build
@Composable
actual fun imageResource(image: String): ImageBitmap = Image.makeFromEncoded(ByteArray(0)).toComposeImageBitmap()