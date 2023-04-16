package net.maiatoday.giith.demos.c_wallpaper.tools

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import net.maiatoday.giith.ui.BlueyBlack
import kotlin.random.Random

class StarfieldPainter(private val starCount:Int = 100) : Painter() {
    override val intrinsicSize = Size.Unspecified

    override fun DrawScope.onDraw() {
        repeat(starCount) {
            val x = random.nextInt(size.width.toInt()).toFloat()
            val y = random.nextInt(size.height.toInt()).toFloat()
            val radius = random.nextInt(5).toFloat()

            drawCircle(
                Color.White,
                center = Offset(x, y),
                radius = radius
            )
        }
    }

    companion object {
        private val random = Random(42)
    }
}

@Composable
fun Starfield() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueyBlack)
            .paint(StarfieldPainter())
    )
}