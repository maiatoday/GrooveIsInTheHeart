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
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.Dp
import net.maiatoday.giith.rainbowtext.vividRainbow
import net.maiatoday.giith.ui.BlueyBlack

//private val defaultBrush = Brush.verticalGradient(listOf(TrollHair, Color.White))
private val defaultBrush = Brush.radialGradient(vividRainbow)

@Composable
fun RainbowDivider(modifier: Modifier = Modifier, brush: Brush = defaultBrush, height: Dp) {
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
                colors = vividRainbow + BlueyBlack,
                center = Offset(offsetX * size.width, center.y)
            ),
            style = Fill,
        )
    }
}