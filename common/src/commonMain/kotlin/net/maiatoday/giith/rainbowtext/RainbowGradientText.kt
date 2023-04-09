package net.maiatoday.giith.rainbowtext

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import isAndroid
import net.maiatoday.giith.ui.Bork
import net.maiatoday.giith.ui.pastelRainbow

val message = "💗‍Welcome to my corner of the Internet 💗"

class ScaledThirdBrush(private val shaderBrush: ShaderBrush) : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        return shaderBrush.createShader(size / 3f)
    }
}

@OptIn(ExperimentalTextApi::class, ExperimentalAnimationApi::class)
@Composable
fun RainbowGradientText(text: String = message) {
    if (isAndroid()) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                brush = ScaledThirdBrush(
                    Brush.linearGradient(
                        colors = pastelRainbow,
                        tileMode = TileMode.Repeated
                    ) as ShaderBrush
                )
            )
        )
    } else {
        Row {
            Bork(size = 48.dp)
            SnappyRainbowText(text = text)
        }
    }

}

@OptIn(ExperimentalTextApi::class, ExperimentalAnimationApi::class)
@Composable
fun GradientText(text: String = message, colors: List<Color> = pastelRainbow) {
    if (isAndroid()) {

        Text(
            text = text,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = colors
                )
            )
        )
    } else {
        Row {
            Bork(size = 48.dp)
            MultiColorText(
                text = text,
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}

@Composable
fun AnotherGradientText(text: String = message, colors: List<Color> = pastelRainbow) {
    Text(
        text = text,
        modifier = Modifier.graphicsLayer(alpha = 0.99f)
            .drawWithCache {
                val brush = Brush.horizontalGradient(colors)
                onDrawWithContent {
                    drawContent()
                    drawRect(brush, blendMode = BlendMode.SrcAtop)
                }
            }
    )
}

@Composable
fun GradientTextShimmer(
    modifier: Modifier = Modifier,
    text: String = message,
    style: TextStyle = LocalTextStyle.current,
    colors: List<Color> = pastelRainbow,
    fontSize: TextUnit = 20.sp
) {
    val currentFontSizePx = with(LocalDensity.current) { fontSize.toPx() }
    val currentFontSizeDoublePx = currentFontSizePx * 2

    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = currentFontSizeDoublePx,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )
    val brush = Brush.linearGradient(
        colors,
        start = Offset(offset, offset),
        end = Offset(offset + currentFontSizePx, offset + currentFontSizePx),
        tileMode = TileMode.Mirror
    )
    Text(
        text = text,
        style = style,
        modifier = modifier.graphicsLayer(alpha = 0.99f)
            .drawWithCache {
                val brush = brush
                onDrawWithContent {
                    drawContent()
                    drawRect(brush, blendMode = BlendMode.SrcAtop)
                }
            }
    )
}