package net.maiatoday.giith.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource

@Composable
actual fun imageResource(image: String): Painter = painterResource("drawable/$image")