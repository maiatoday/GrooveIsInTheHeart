package net.maiatoday.giith.sketch

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import net.maiatoday.giith.components.Choices
import net.maiatoday.giith.components.drawModifier
import net.maiatoday.giith.tools.*
import kotlin.random.Random

//region Dots with choices - for later don't look
@Composable
fun AllTheDots(choices: Choices = Choices(), points:List<Offset>) {
    Canvas(modifier = drawModifier) {
        repeat(choices.dotCount) {
            drawCircle(
                color = if (choices.rainbowDots) randomThemeColor()  else randomGrey(),
                center = points[it],
                radius = Random.nextInt(10, 50).toFloat(),
                style = Fill,
            )
        }
    }
}

//endregion
