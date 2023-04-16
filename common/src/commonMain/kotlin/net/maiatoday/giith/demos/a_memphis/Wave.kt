package net.maiatoday.giith.demos.a_memphis

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.randomDegrees
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.pastelRainbow
import net.maiatoday.giith.ui.vividRainbow

@Composable
fun AllTheWaves(modifier: Modifier = Modifier, spacingDp: Int, waveSizeDp: IntSize) {
    if (waveSizeDp.width == 0) return
    if (waveSizeDp.height == 0) return
    val sizePx = waveSizeDp.toPxOffset()
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx()
        val h = this.maxHeight.toPx()
        val spacing = spacingDp.dp.toPx()
        val points = buildPoissonDiscPoints(Size(w, h), spacing)
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
                        sizePx
                    )
                }
            }
        }
    }
}

fun DrawScope.drawWaveShadow(color: Color, shadow: Color, offset: Offset, delta: Offset) {
    drawWave(shadow, Offset(offset.x + 10, offset.y + 10), delta)
    drawWave(color, offset, delta)
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

@Composable
private fun IntSize.toPxOffset():Offset = Offset(width.dp.toPx(), height.dp.toPx())