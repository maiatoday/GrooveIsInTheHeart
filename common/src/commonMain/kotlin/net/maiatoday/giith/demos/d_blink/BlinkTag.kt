package net.maiatoday.giith.demos.d_blink

import androidx.compose.animation.core.*
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration







//region BlinkTag
@Composable
fun BlinkTag(
    modifier: Modifier = Modifier,
    duration: Int = 500,
    content: @Composable (modifier: Modifier) -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()
    val alpha: Float by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = duration
                1f at (duration*0.8).toInt()
                0f at duration
            },
            repeatMode = RepeatMode.Reverse
        )
    )
    content(modifier.alpha(alpha))
}
//endregion

//region BlinkText
@Composable
fun BlinkText(
    modifier: Modifier = Modifier,
    text: String,
    color: Color = Color.Unspecified,
    style: TextStyle = LocalTextStyle.current,
    durationMillis: Int = 1000,
    textDecoration:TextDecoration = TextDecoration.None
) {
    BlinkTag(modifier = modifier, duration = durationMillis) {
        Text(modifier = it, text = text, style = style, color = color, textDecoration = textDecoration)
    }
}
//endregion


