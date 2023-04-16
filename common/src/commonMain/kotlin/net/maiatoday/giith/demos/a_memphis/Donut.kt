package net.maiatoday.giith.demos.a_memphis

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.vividRainbow
import kotlin.random.Random

// State spacing, size, fill
@Composable
fun AllTheDonuts(
    modifier: Modifier = Modifier,
    spacingDp: Int,
    sizeDp: Int,
    fill: Boolean
) {
    if (sizeDp == 0) return

    BoxWithConstraints(modifier) {
        val spacing = spacingDp.dp.toPx()
        val size = sizeDp.dp.toPx().toInt()
        val points = buildPoissonDiscPoints(Size(this.maxWidth.toPx(), this.maxHeight.toPx()), spacing)

        // Visible draw on the canvas
        Canvas(modifier = Modifier.fillMaxSize()) {
            for (point in points) {
                drawCircle(
                    color = vividRainbow.random(),
                    center = point,
                    radius = Random.nextInt(size - 20, size + 20).toFloat(),
                    style = if (fill) Fill else Stroke(width = Random.nextInt(2, 10).toFloat()),
                )
            }
        }
    }
}