@file:OptIn(ExperimentalAnimationApi::class, ExperimentalAnimationApi::class)

package net.maiatoday.giith.demos.e_visitorcounter

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import kotlin.math.pow







//region CounterCell
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CounterCell(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    count: Int,
    width: Int
) {
    // >>>>>>> State and visible change in one
    val numbersSlidingAnimation: AnimatedContentScope<Int>.() -> ContentTransform =
        {
            if (initialState > targetState) {
                slideInVertically(initialOffsetY = { it }) + fadeIn() with
                        slideOutVertically(targetOffsetY = { -it }) + fadeOut()
            } else {
                slideInVertically(initialOffsetY = { -it }) + fadeIn() with
                        slideOutVertically(targetOffsetY = { it }) + fadeOut()
            }
        }
    AnimatedContent(
        targetState = count,
        transitionSpec = numbersSlidingAnimation
    ) { number ->
        Text(
            modifier = modifier,
            text = number.toString().padStart(width, '0'),
            style = style
        )
    }
}
//endregion

//region Counter
@Composable
fun Counter(
    modifier: Modifier = Modifier,
    style: TextStyle = LocalTextStyle.current,
    onClick: () -> Unit,
    count: Int,
    width: Int
) {
    val displayWidth = maxOf(3, width)
    Row(
        modifier = Modifier.clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
            onClick = onClick
        ),
    ) {
        for (n in displayWidth - 1 downTo 0) {
            CounterCell(
                modifier = modifier,
                style = style,
                count = (count.toDouble() / 10.0.pow(n) % 10).toInt(),
                width = 1
            )
        }
    }
}
//endregion


