package net.maiatoday.giith.demos.f_rainbowtext

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import net.maiatoday.giith.ui.pastelRainbow
import net.maiatoday.giith.ui.vividRainbow

@ExperimentalAnimationApi
@Composable
fun MultiColorText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = pastelRainbow,
    startColor: Int = 0,
) {
    Row(modifier) {
        var index = startColor
        for (letter in text) {
            Text(letter.toString(), color = rainbow.get(index), style = style)
            index++
            if (index == rainbow.size) index = 0
        }

    }
}

@ExperimentalAnimationApi
@Composable
fun SnappyRainbowText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = vividRainbow
) {
    require(rainbow.isNotEmpty())
    val infiniteTransition = rememberInfiniteTransition()
    val colorIndex by infiniteTransition.animateValue(
        initialValue = 0,
        targetValue = rainbow.size - 1,
        typeConverter = Int.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(),
            repeatMode = RepeatMode.Restart
        )
    )
    MultiColorText(
        text = text,
        style = style,
        modifier = modifier,
        startColor = colorIndex,
        rainbow = rainbow
    )
}

@ExperimentalAnimationApi
@Composable
fun TwoColorSmoothText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    startColor: Color,
    endColor: Color
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = startColor,
        targetValue = endColor,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        )
    )
    Text(text = text, color = color, style = style, modifier = modifier)
}
