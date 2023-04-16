package net.maiatoday.giith.demos.c_wallpaper.tools

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter

class StarPainter(private val starColor: Color, private val stars:List<Offset>) : Painter() {
    override val intrinsicSize = Size.Unspecified

    override fun DrawScope.onDraw() {
        for (starPoint in stars) {
            drawCircle(
                starColor,
                center = starPoint,
                radius = 2f
            )
        }
    }
}