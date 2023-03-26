package net.maiatoday.giith.sketch

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.TrollHair

private val drawModifier = Modifier
    .fillMaxSize()
    .clipToBounds()
//region Gradient Brush
val brush = Brush.verticalGradient(listOf(TrollHair, Color.White))
//val brush = Brush.horizontalGradient(listOf(Color.Red, Color.Magenta, Color.White, Color.Red))
//val brush = Brush.radialGradient(listOf(Color.Red, Color.Magenta, Color.White, Color.LightGray))
//val brush = Brush.radialGradient(listOf(Minty, Sky, Bluebell, Color.White))

@Composable
fun BrushSwatch() {
    Canvas(modifier = drawModifier) {
        drawRect(
            brush = brush,
            style = Fill,
        )
    }
}
//endregion

//region Gradient brush with stops
@Composable
fun BoxBrushSwatch() {
    val colorStops = arrayOf(
        0.0f to Color.Red,
        0.2f to Color.White,
        1f to Color.Magenta
    )
    Box(
        modifier = Modifier
            .requiredSize(200.dp)
            .background(Brush.horizontalGradient(colorStops = colorStops))
    )
}
//endregion

//region Messy brushes - don't look
@Composable
fun ColorSwatch() {
    Canvas(modifier = drawModifier) {
        val swatchSize = 250.dp.toPx()
        drawRect(
            color = Color.Magenta,
            style = Fill,
            topLeft = Offset(center.x - swatchSize/2, center.y - swatchSize/2),
            size = Size(swatchSize,swatchSize)
        )
    }
}

//val pinkToWhite = listOf(
//    Color(255, 105, 180),
//    Color(255, 255, 255),
//)

//val rgbRainbow = listOf(
//    Color.Red,
//    Color.Yellow,
//    Color.Green,
//    Color.Cyan,
//    Color.Blue,
//    Color.Magenta
//)
//endregion


