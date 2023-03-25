package net.maiatoday.giith.sketch

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import net.maiatoday.giith.ui.components.Choices
import net.maiatoday.giith.ui.components.drawModifier
import net.maiatoday.giith.tools.randomColor
import net.maiatoday.giith.tools.randomGrey
import net.maiatoday.giith.tools.randomOffset
import net.maiatoday.giith.tools.randomThemeColor


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