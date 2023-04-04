package net.maiatoday.giith.gaudydivider

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import net.maiatoday.giith.ui.*

private val sparkColours = listOf(
    Oros,
    Color.Yellow,
    TasteyWheat,
    Color.White,
    SherbetBomb,
)

@Composable
fun SparkDivider(modifier: Modifier = Modifier, height: Dp) {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = modifier.fillMaxWidth().height(height)) {
        drawRect(
            brush = Brush.radialGradient(
                colors = sparkColours,
                center = Offset(offsetX * size.width, center.y)
            ),
            style = Fill,
        )
    }
}