package net.maiatoday.giith.underconstruction

import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.lang.Math.round
import kotlin.math.roundToInt

@Composable
fun Chevron(
    modifier: Modifier = Modifier,
    stripWidth: Dp = 20.dp,
    fgColor: Color = Color.Yellow,
    bgColor: Color = Color.Black,
    textColor: Color = Color.Red,
    shadowColor: Color = Color.Black,
    text: String = "UNDER CONSTRUCTION"
) {

    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateFloat(
        initialValue = 0.0f, targetValue = 2.0f, animationSpec = infiniteRepeatable(
            animation = tween(500), repeatMode = RepeatMode.Restart
        )
    )
    Box(modifier = modifier) {
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

        Text(
            text = text,
            style = MaterialTheme.typography.headlineMedium.copy(
                shadow = Shadow(
                    color = shadowColor,
                    offset = Offset(4f, 4f),
                    blurRadius = 8f
                )
            ),
           // fontSize = 32.sp,
            color = textColor,
           // fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}
