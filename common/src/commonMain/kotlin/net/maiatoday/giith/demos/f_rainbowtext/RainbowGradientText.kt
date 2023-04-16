@file:OptIn(ExperimentalTextApi::class, ExperimentalTextApi::class, ExperimentalTextApi::class,
    ExperimentalTextApi::class
)

package net.maiatoday.giith.demos.f_rainbowtext

import androidx.compose.animation.core.*
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.unit.sp
import net.maiatoday.giith.ui.MyPonyHair
import net.maiatoday.giith.ui.pastelRainbow

// Thank you, Alejandra 🙏😎 for the
// Brushing up on Text Coloring medium post
const val message = "💗‍Welcome to my corner of the Internet 💗"

//region Gradient text shimmer
@Composable
fun GradientTextShimmer(
    modifier: Modifier = Modifier,
    text: String = message,
    style: TextStyle = LocalTextStyle.current,
    colors: List<Color> = pastelRainbow,
    fontSize: TextUnit = 20.sp,
) {
    //region Setup size parameters
    val currentFontSizePx = with(LocalDensity.current) { fontSize.toPx() }
    val currentFontSizeDoublePx = currentFontSizePx * 2
    //endregion

    //region State control
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
    //endregion

    //region Use Brush on text
    Text(
        text = text,
        modifier = modifier,
        style = style.copy(
            brush = brush
        )
    )
    //endregion
}

//endregion

//region more gradient experiments - don't look
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

class ScaledThirdBrush(private val shaderBrush: ShaderBrush) : ShaderBrush() {
    override fun createShader(size: Size): Shader {
        return shaderBrush.createShader(size / 3f)
    }
}

@Composable
fun RainbowGradientText(
    text: String = message,
    style: TextStyle = LocalTextStyle.current
) {
    Text(
        text = text,
        style = style.copy(
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
}

@Composable
fun GradientText(
    text: String = message, colors: List<Color> = pastelRainbow,
    style: TextStyle = LocalTextStyle.current
) {
    val offset = Offset(5.0f, 10.0f)
    Text(
        text = text,
        style = style.copy(
            brush = Brush.linearGradient(
                colors = colors
            ),
            shadow = Shadow(
                color = MyPonyHair, offset = offset, blurRadius = 3f
            )
        )
    )
}
//endregion

