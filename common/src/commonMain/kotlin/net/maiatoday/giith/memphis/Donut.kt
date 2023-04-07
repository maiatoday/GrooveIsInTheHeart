package net.maiatoday.giith.memphis

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.vividRainbow
import kotlin.random.Random

@Composable
fun AllTheDonuts(modifier: Modifier = Modifier, delta: Float = 80f, fill: Boolean) {
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx()
        val h = this.maxHeight.toPx()
        val points by remember { mutableStateOf(buildPoissonDiscPoints(Size(w, h), delta*3)) }
        Canvas(modifier = Modifier.fillMaxSize()) {
            for (point in points) {
                drawCircle(
                    color = vividRainbow.random(),
                    center = point,
                    radius = Random.nextInt(10, 50).toFloat(),
                    style = if (fill) Fill else Stroke(width = Random.nextInt(2, 10).toFloat()),
                )
            }
        }
    }
}