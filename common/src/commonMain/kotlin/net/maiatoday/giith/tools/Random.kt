package net.maiatoday.giith.tools

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.toSize
import net.maiatoday.giith.ui.grooveColors
import kotlin.random.Random

fun randomThemeColor(): Color = grooveColors.random()

fun randomColor(): Color {
    val colorRange = 0..255
    val r = colorRange.random()
    val g = colorRange.random()
    val b = colorRange.random()
    return Color(r, g, b)
}

fun randomGrey(): Color {
    val colorRange = 0..255
    val c = colorRange.random()
    return Color(c, c, c)
}

const val DOT_COUNT = 200
fun randomOffset(size: Size) =
    Offset(
        x = Random.nextInt(0, size.width.toInt()).toFloat(),
        y = Random.nextInt(0, size.height.toInt()).toFloat()
    )

fun randomDegrees() = Random.nextInt(0, 360).toFloat()

fun randomRotations(max: Int, multiplier: Float = 5f) = buildList<Float> {
    repeat(max) {
        add(Random.nextFloat() * multiplier - multiplier)
    }
}

fun buildPoints(size: IntSize, count: Int): List<Offset> = buildList {
    repeat(count + 1) {
        add(randomOffset(size.toSize()))
    }
}


