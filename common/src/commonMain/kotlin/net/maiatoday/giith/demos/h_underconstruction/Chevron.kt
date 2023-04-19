package net.maiatoday.giith.demos.h_underconstruction

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.tools.toPx
import kotlin.math.roundToInt







//region Chevron with Gradient
@Composable
fun Chevron(
    modifier: Modifier = Modifier,
    stripWidth: Dp = 20.dp,
    fgColor: Color = Color.Yellow,
    bgColor: Color = Color.Black,
    textColor: Color = Color.Red,
    shadowColor: Color = Color.Black,
    text: String = "UNDER CONSTRUCTION",
    textStyle: TextStyle = MaterialTheme.typography.headlineMedium
) {
    //region some size setting
    val deltaPx = stripWidth.toPx()
    val deltaDoublePx = deltaPx * 2
    //end region

    //region State setup
    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = deltaDoublePx,
        animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))
    )
    val colorStops = arrayOf(
        0.0f to bgColor,
        0.3f to bgColor,
        0.31f to fgColor,
        1f to fgColor
    )
    val shimmerBrush = Brush.linearGradient(
        colorStops = colorStops,
        start = Offset(offset, offset),
        end = Offset(offset + deltaPx, offset + deltaPx),
        tileMode = TileMode.Repeated
    )
    //endregion

    //region Drawing Chevron and text
    Box(modifier = modifier) {

        //Drawing Canvas with brush
        Canvas(modifier = modifier.fillMaxWidth().height(stripWidth)) {
            drawRect(
                brush = shimmerBrush,
                style = Fill,
            )
        }

        //region Text with Shadow
        Text(
            text = text,
            style = textStyle.copy(
                shadow = Shadow(
                    color = shadowColor,
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            ),
            color = textColor,
            modifier = Modifier.align(Alignment.Center)
        )
        //endregion
    }
    //endregion
}
//endregion

//region Chevron with Canvas and rectangles ... Heavy 😰
@Composable
fun ChevronHeavy(
    modifier: Modifier = Modifier,
    stripWidth: Dp = 20.dp,
    fgColor: Color = Color.Yellow,
    bgColor: Color = Color.Black,
    textColor: Color = Color.Red,
    shadowColor: Color = Color.Black,
    text: String = "UNDER CONSTRUCTION"
) {

    //region State setup
    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateFloat(
        initialValue = 0.0f,
        targetValue = 2.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(500),
            repeatMode = RepeatMode.Restart
        )
    )
    //endregion

    //region Drawing Chevron and text
    Box(modifier = modifier) {
        //region Complicated Canvas and rectangle drawing
        Canvas(
            modifier = modifier
                .fillMaxSize()
                .clipToBounds()
                .background(bgColor)
        ) {
            val stripPx = stripWidth.toPx()
            val count = (size.width / stripPx).roundToInt()
            val height = size.height

            val delta = offset * stripPx
            val stripHeight = height * 25F
            val stripSize = Size(stripPx, stripHeight)
            val rotation = 45f
            for (i in -10..count + 10 step 2) {
                //   for (r in 0..45) {
                withTransform({
                    rotate(degrees = rotation, pivot = Offset(i * stripPx + delta, height / 2))
                    translate(left = i * stripPx + delta, top = -90F)
                }) {
                    drawRect(
                        color = fgColor, size = stripSize
                    )
                }
            }
        }
        //endregion

        //region Text with shadow
        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium.copy(
                shadow = Shadow(
                    color = shadowColor,
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            ),
            color = textColor,
            modifier = Modifier.align(Alignment.Center)
        )
        //endregion
    }
    //endregion
}
//endregion
