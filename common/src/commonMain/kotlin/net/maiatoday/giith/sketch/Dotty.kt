package net.maiatoday.giith.sketch

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Fill
import net.maiatoday.giith.tools.randomGrey
import net.maiatoday.giith.tools.randomThemeColor
import kotlin.random.Random

private val drawModifier = Modifier
    .fillMaxSize()
    .clipToBounds()
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
