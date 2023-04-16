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
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.withTransform
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.tools.buildPoissonDiscPoints
import net.maiatoday.giith.tools.randomDegrees
import net.maiatoday.giith.tools.toPx
import net.maiatoday.giith.ui.pastelRainbow
import net.maiatoday.giith.ui.vividRainbow

const val shadowOffsetTriangle = 10

@Composable
fun AllTheTriangles(modifier: Modifier = Modifier, spacingDp: Int, sizeDp: Int, fill: Boolean) {
    if (sizeDp == 0) return
    BoxWithConstraints(modifier) {
        val w = this.maxWidth.toPx()
        val h = this.maxHeight.toPx()
        val spacing = spacingDp.dp.toPx()
        val size = sizeDp.dp.toPx()
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
                    drawTriangleShadow(
                        color = pastelRainbow.random(),
                        shadow = vividRainbow.random(),
                        offset = Offset.Zero,
                        fill = fill,
                        sizePx = size
                    )
                }
            }
        }
    }
}

fun DrawScope.drawTriangleShadow(color: Color, shadow: Color, offset: Offset, fill: Boolean, sizePx: Float) {
    val deltaOffset = Offset(sizePx, sizePx)
    drawTriangle(shadow, Offset(offset.x + shadowOffsetTriangle, offset.y + shadowOffsetTriangle), deltaOffset, fill)
    drawTriangle(color, offset, deltaOffset, fill)
}

fun DrawScope.drawTriangle(color: Color, center: Offset, sizePx: Offset, fill: Boolean) {
    val path = Path()
    path.moveTo(center.x, center.y - sizePx.y)
    path.lineTo(center.x - sizePx.x, center.y + sizePx.y)
    path.lineTo(center.x + sizePx.x, center.y + sizePx.y)
    path.close()
    drawPath(path, color, style = if (fill) Fill else Stroke(width = 10f))
}