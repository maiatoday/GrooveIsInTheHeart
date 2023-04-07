package net.maiatoday.giith.memphis

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
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.randomDegrees
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.pastelRainbow
import net.maiatoday.giith.ui.vividRainbow

const val shadowOffsetTriangle = 10

@Composable
fun AllTheTriangles(modifier: Modifier = Modifier, delta: Float = 80f, fill: Boolean) {
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx()
        val h = this.maxHeight.toPx()
        val points = buildPoissonDiscPoints(Size(w, h), delta * 3)
        Canvas(modifier = Modifier.fillMaxSize()) {
            for (point in points) {
                withTransform({
                    translate(point.x, point.y)
                    rotate(
                        degrees = randomDegrees(),
                        pivot = Offset.Zero
                    )
                }) {
                    drawTriangleShadow(
                        color = pastelRainbow.random(),
                        shadow = vividRainbow.random(),
                        offset = Offset.Zero,
                        fill = fill,
                        delta = delta
                    )
                }
            }
        }
    }
}

fun DrawScope.drawTriangleShadow(color: Color, shadow: Color, offset: Offset, fill: Boolean, delta: Float) {
    val deltaOffset = Offset(delta, delta)
    drawTriangle(shadow, Offset(offset.x + shadowOffsetTriangle, offset.y + shadowOffsetTriangle), deltaOffset, fill)
    drawTriangle(color, offset, deltaOffset, fill)
}

fun DrawScope.drawTriangle(color: Color, center: Offset, delta: Offset, fill: Boolean) {
    val path = Path()
    path.moveTo(center.x, center.y - delta.y)
    path.lineTo(center.x - delta.x, center.y + delta.y)
    path.lineTo(center.x + delta.x, center.y + delta.y)
    path.close()
    drawPath(path, color, style = if (fill) Fill else Stroke(width = 10f))
}