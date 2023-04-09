package net.maiatoday.giith.gaudydivider

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.rainbowtext.rainbowAnimatedColor
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.*

private val sparkColours = listOf(
    Oros,
    Color.Yellow,
    TasteyWheat,
    Color.White,
    SherbetBomb,
)

private val sparkCenter = listOf(
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

@Composable
fun MoarSparkDivider(modifier: Modifier = Modifier, height: Dp) {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val lastColor by infiniteTransition.animateColor(
        initialValue = SherbetBomb,
        targetValue = BlueyBlack,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = modifier.fillMaxWidth().height(height)) {
        drawRect(
            brush = Brush.radialGradient(
                colors = sparkCenter + lastColor,
                center = Offset(offsetX * size.width, center.y)
            ),
            style = Fill,
        )
    }
}

@Composable
fun RainbowSparkDivider(modifier: Modifier = Modifier, height: Dp) {
    val infiniteTransition = rememberInfiniteTransition()
    val offsetX by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 1.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val lastColor = rainbowAnimatedColor(3000, pastelRainbow)
    Canvas(modifier = modifier.fillMaxWidth().height(height)) {
        drawRect(
            brush = Brush.radialGradient(
                colors = sparkCenter + lastColor,
                center = Offset(offsetX * size.width, center.y)
            ),
            style = Fill,
        )
    }
}


@Composable
fun SherbetBombDivider(modifier: Modifier = Modifier) = PlainDivider(modifier, SherbetBomb)

@Composable
fun LintDivider(modifier: Modifier = Modifier) = PlainDivider(modifier, Lint)

@Composable
fun PlainDivider(modifier: Modifier = Modifier, color: Color) {
    Spacer(modifier.background(color).height(2.dp).fillMaxWidth())
}

@Composable
fun ShimmerDivider(modifier: Modifier = Modifier, colors:List<Color> = pastelRainbow, height:Dp = 8.dp) {
    val deltaPx = height.toPx()
    val deltaDoublePx = deltaPx * 2

    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = deltaDoublePx,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )
    val shimmerBrush = Brush.linearGradient(
        colors,
        start = Offset(offset, offset),
        end = Offset(offset + deltaPx, offset + deltaPx),
        tileMode = TileMode.Repeated
    )
    Canvas(modifier = modifier.fillMaxWidth().height(height)) {
        drawRect(
            brush = shimmerBrush,
            style = Fill,
        )
    }
}