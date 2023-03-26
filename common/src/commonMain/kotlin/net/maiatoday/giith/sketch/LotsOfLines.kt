package net.maiatoday.giith.sketch

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import net.maiatoday.giith.tools.randomGrey
import net.maiatoday.giith.tools.randomThemeColor

private val drawModifier = Modifier
    .fillMaxSize()
    .clipToBounds()
//region Lines with choices - For later don't look
@Composable
fun AllTheLines(choices: Choices = Choices(), points:List<Offset>) {
    Canvas(modifier = drawModifier) {
        repeat(choices.dotCount) {
            drawLine(
                color = if (choices.rainbowLines) randomThemeColor() else randomGrey(),
                strokeWidth = 4f,
                start = points[it],
                end = points[it+1]
            )
        }
    }
}
//endregion