package net.maiatoday.giith.memphis

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.randomDegrees
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.pastelRainbow
import net.maiatoday.giith.ui.vividRainbow

@Composable
fun AllTheWaves(modifier: Modifier = Modifier, delta: Float = 80f) {
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx()
        val h = this.maxHeight.toPx()
        val points by remember { mutableStateOf(buildPoissonDiscPoints(Size(w, h), delta * 3)) }
        Canvas(modifier = Modifier.fillMaxSize()) {
            for (point in points) {
                withTransform({
                    translate(point.x, point.y)
                    rotate(
                        degrees = randomDegrees(),
                        pivot = Offset.Zero
                    )
                }) {
                    drawWaveShadow(
                        color = pastelRainbow.random(),
                        shadow = vividRainbow.random(),
                        Offset.Zero,
                        delta
                    )
                }
            }
        }
    }
}

fun DrawScope.drawWaveShadow(color: Color, shadow: Color, offset: Offset, delta: Float) {
    val deltaOffset = Offset(delta, delta*1.2f)
    drawWave(shadow, Offset(offset.x + 10, offset.y + 10), deltaOffset)
    drawWave(color, offset, deltaOffset)
}

fun DrawScope.drawWave(color: Color, center: Offset, delta: Offset) {
    val zigzag = Path()
    zigzag.moveTo(center.x - delta.x, center.y)
    zigzag.lineTo(center.x - delta.x / 2, center.y - delta.y)
    zigzag.lineTo(center.x, center.y)
    zigzag.lineTo(center.x + delta.x / 2, center.y - delta.y)
    zigzag.lineTo(center.x + delta.x, center.y)
    zigzag.lineTo(center.x + delta.x + delta.x / 2, center.y - delta.y)
    drawPath(zigzag, color, style = Stroke(width = 10f))
}