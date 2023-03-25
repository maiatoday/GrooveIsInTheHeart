package net.maiatoday.giith.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color

@Composable
fun Page(
    modifier: Modifier = Modifier.fillMaxSize(),
    color: Color = Color.White,
    content: @Composable () -> Unit
) {
    val drawModifier = modifier
        .background(color)
        .clipToBounds()
    Surface(modifier = drawModifier) {
        content()
    }
}
val drawModifier = Modifier
    .fillMaxSize()
    .clipToBounds()