package net.maiatoday.giith.heartpath

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.*
import net.maiatoday.giith.tools.DOT_COUNT
import net.maiatoday.giith.tools.randomColor
import net.maiatoday.giith.tools.randomGrey
import net.maiatoday.giith.tools.randomOffset
import net.maiatoday.giith.ui.BlueyBlack
import net.maiatoday.giith.ui.MyPonyHair

private val drawModifier = Modifier
    .fillMaxSize()
    .clipToBounds()

//region Heart path
//// Thank You https://mahendranv.github.io/posts/compose-shapes-gists/
val heartSize = Size(150f, 150f)
val heartPath = Path().apply {
    val w = heartSize.width
    val h = heartSize.height
    moveTo(0.5f * w, 0.25f * h)
    cubicTo(
        0.5f * w, 0.225f * h,
        0.45833f * w, 0.125f * h,
        0.291667f * w, 0.125f * h
    )
    cubicTo(0.041667f * w, 0.125f * h, 0.041667f * w, 0.4f * h, 0.041667f * w, 0.4f * h)
    cubicTo(0.041667f * w, 0.58333f * h, 0.20833f * w, 0.76667f * h, 0.5f * w, 0.91667f * h)
    cubicTo(0.791667f * w, 0.76667f * h, 0.95833f * w, 0.58333f * h, 0.95833f * w, 0.4f * h)
    cubicTo(0.9533f * w, 0.4f * h, 0.95833f * w, 0.125f * h, 0.70833f * w, 0.125f * h)
    cubicTo(0.5833f * w, 0.125f * h, 0.5f * w, 0.225f * h, 0.5f * w, 0.25f * h)
    close()
}

//region Candy Heart
val candyColours = listOf(Color.Red, Color.Magenta, MyPonyHair)

@Composable
fun CandyHeartPulse() {
    val candyBrush = remember {
        object : ShaderBrush() {
            override fun createShader(size: Size): Shader {
                return LinearGradientShader(
                    colors = candyColours,
                    from = Offset.Zero,
                    to = Offset(heartSize.width / 4f, 0f),
                    tileMode = TileMode.Mirror
                )
            }
        }
    }
    val infiniteTransition = rememberInfiniteTransition()
    val heartScale by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 2.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = drawModifier) {
        withTransform({
            scale(heartScale)
            translate(center.x - heartSize.width / 2, center.y - heartSize.height / 2)

        }) {
            drawPath(
                path = heartPath,
                brush = candyBrush,
                style = Fill
            )
        }
    }
}

//endregion
//region Heart pulse
@Composable
fun HeartPulse() {
    val infiniteTransition = rememberInfiniteTransition()
    val heartScale by infiniteTransition.animateFloat(
        initialValue = 0.5f,
        targetValue = 1.5f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    val heartColor by infiniteTransition.animateColor(
        initialValue = Color.Magenta,
        targetValue = Color.Red,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Canvas(modifier = drawModifier) {
        withTransform({
            scale(heartScale)
            translate(center.x - heartSize.width / 2, center.y - heartSize.height / 2)

        }) {
            drawPath(
                heartPath,
                color = heartColor,
                style = Fill
            )
        }
    }
}
//endregion

//region Messy - don't look
@Composable
fun HappyHearts() {
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            val d = randomOffset(size)
            translate(d.x, d.y) {
                drawPath(heartPath, randomColor(), style = Fill)
            }
        }
    }
}

@Composable
fun SadHearts() {
    Canvas(modifier = drawModifier) {
        repeat(DOT_COUNT) {
            val d = randomOffset(size)
            translate(d.x, d.y) {
                drawPath(heartPath, randomGrey(), style = Fill)
            }
        }
    }
}
//endregion