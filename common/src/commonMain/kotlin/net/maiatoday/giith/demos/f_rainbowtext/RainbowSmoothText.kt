package net.maiatoday.giith.demos.f_rainbowtext

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import net.maiatoday.giith.ui.pastelRainbow






//region The rainbow animation
@Composable
fun rainbowAnimatedColor(
    duration: Int,
    rainbow: List<Color>,
    startIndex: Int = 0
): Color {
    val infiniteTransition = rememberInfiniteTransition()
    val interval = duration / rainbow.size
    val color by infiniteTransition.animateColor(
        initialValue = rainbow[0],
        targetValue = rainbow.last(),
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration
                delayMillis = startIndex * interval / 2
                var i = 0
                for (color in rainbow) {
                    color at i
                    i += interval
                }
            },
            repeatMode = RepeatMode.Restart
        )
    )
    return color
}
//endregion

//region Multicolor smooth text
@Composable
fun MultiColorSmoothText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = pastelRainbow,
    startIndex: Int = 0,
    duration: Int
) {
    val color = rainbowAnimatedColor(duration, rainbow, startIndex)
    Text(text = text, color = color, style = style, modifier = modifier)
}
//endregion

//region Rainbow Letters Smooth text
@Composable
fun SmoothRainbowText(
    modifier: Modifier = Modifier,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    rainbow: List<Color> = pastelRainbow,
    startColor: Int = 0,
    duration: Int = 1200
) {
    Row(modifier) {
        var index = startColor
        for (letter in text) {
            MultiColorSmoothText(
                text = letter.toString(),
                style = style,
                rainbow = rainbow,
                startIndex = index,
                duration = duration
            )
            index++
            if (index == rainbow.size) index = 0
        }
    }
}
//endregion

