package net.maiatoday.giith.demos.h_underconstruction

import androidx.compose.animation.core.*
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
const val underConstruction:String = "/ / / / / / / / / / / / / /  UNDER CONSTRUCTION / / / / / / / / / / / /"

//region Under Construction with marquee
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UnderConstructionMarquee(
    text: String = underConstruction,
) {
    Column(Modifier.width(300.dp)) {
        Text(
            text = text,
            modifier = Modifier
                .basicMarquee()
                .background(Color.Black),
            color = Color.Yellow
        )
    }
}
//endregion

//region Under Construction with offset animation
@Composable
fun TextMarqueeManual(
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
fun UnderConstructionMarqueeManual() {
    TextMarqueeManual(
        text = "/ / / / / / / / / / / / / /  UNDER CONSTRUCTION / / / / / / / / / / / /",
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
    )
}
//endregion

