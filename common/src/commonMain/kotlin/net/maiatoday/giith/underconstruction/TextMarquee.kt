package net.maiatoday.magicsprinkles.ui.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TextMarquee(
    text: String,
    modifier: Modifier = Modifier,
    textColour: Color = Color.Yellow,
) {
    val infiniteTransition = rememberInfiniteTransition()
    val offset by infiniteTransition.animateValue(
        initialValue = -300.dp,
        targetValue = 300.dp,
        typeConverter = Dp.VectorConverter,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
    Box(modifier = modifier) {
        Text(
            modifier = Modifier.offset(x = offset),
            text = text,
            color = textColour,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1
        )
    }
}

@Composable
fun UnderConstructionMarquee() {
    TextMarquee(
        text = "/ / / / / / / / / / / / / /  UNDER CONSTRUCTION / / / / / / / / / / / /",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    )

}
