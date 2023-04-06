package net.maiatoday.giith.memphis

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import getPlatformName
import net.maiatoday.giith.tools.buildPoints
import net.maiatoday.giith.tools.randomDegrees
import net.maiatoday.giith.tools.randomGrey
import net.maiatoday.giith.ui.pastelRainbow
import net.maiatoday.giith.ui.vividRainbow
import kotlin.random.Random

@Composable
fun MemphisScreen() {
    var choices by remember { mutableStateOf(MemphisChoices()) }
    var donutPoints by remember { mutableStateOf(buildPoints(choices.size, MAX_SHAPE_COUNT)) }
    var trianglePoints by remember { mutableStateOf(buildPoints(choices.size, MAX_SHAPE_COUNT)) }
    var wavePoints by remember { mutableStateOf(buildPoints(choices.size, MAX_SHAPE_COUNT)) }

    val settingsModifier = Modifier
        .requiredWidth(200.dp)
        .fillMaxHeight()
        .clipToBounds()

    val pageModifier = Modifier
        .requiredWidth(1000.dp)
        .fillMaxHeight()
        .clipToBounds()
    Row(modifier = Modifier.wrapContentSize()) {
        MemphisPanel(
            modifier = settingsModifier,
            choices = choices,
            version = "Hello ${getPlatformName()}",
            onNewPoints = {
                donutPoints = buildPoints(choices.size, MAX_SHAPE_COUNT)
                trianglePoints = buildPoints(choices.size, MAX_SHAPE_COUNT)
                wavePoints = buildPoints(choices.size, MAX_SHAPE_COUNT)
            }
        ) { choices = it }
        Surface(modifier = pageModifier.onSizeChanged {
            donutPoints = buildPoints(it, MAX_SHAPE_COUNT)
            trianglePoints = buildPoints(it, MAX_SHAPE_COUNT)
            wavePoints = buildPoints(it, MAX_SHAPE_COUNT)
            choices = choices.copy(size = it)
        }) {
            if (choices.triangleCount > 0) AllTheTriangles(choices, trianglePoints)
            if (choices.dotCount > 0) AllTheDonuts(choices, donutPoints)
            if (choices.waveCount > 0) AllTheWaves(choices, wavePoints)
        }
    }
}

@Composable
fun AllTheDonuts(choices: MemphisChoices, points: List<Offset>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        repeat(choices.dotCount) {
            drawCircle(
                color = if (choices.brightDots) vividRainbow.random() else randomGrey(),
                center = points[it],
                radius = Random.nextInt(10, 50).toFloat(),
                style = Stroke(width = 10f),
            )
        }
    }
}

@Composable
fun AllTheTriangles(choices: MemphisChoices, points: List<Offset>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        repeat(choices.triangleCount) {
            withTransform({
                translate(points[it].x, points[it].y)
                rotate(
                    degrees = randomDegrees(),
                    pivot = Offset.Zero
                )
            }) {
                drawTriangleShadow(
                    color = if (choices.brightTriangles) pastelRainbow.random() else randomGrey(),
                    shadow = if (choices.brightTriangles) vividRainbow.random() else randomGrey(),
                    offset = Offset.Zero,
                    fill = choices.triangleFill
                )
            }
        }
    }
}

fun DrawScope.drawTriangleShadow(color: Color, shadow: Color, offset: Offset, fill: Boolean) {
    val delta = Offset(80f, 80f)
    drawTriangle(shadow, Offset(offset.x + 10, offset.y + 10), delta, fill)
    drawTriangle(color, offset, delta, fill)
}

fun DrawScope.drawTriangle(color: Color, center: Offset, delta: Offset, fill: Boolean) {
    val path = Path()
    path.moveTo(center.x, center.y - delta.y)
    path.lineTo(center.x - delta.x, center.y + delta.y)
    path.lineTo(center.x + delta.x, center.y + delta.y)
    path.close()
    drawPath(path, color, style = if (fill) Fill else Stroke(width = 10f))
}

@Composable
fun AllTheWaves(choices: MemphisChoices, points: List<Offset>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        repeat(choices.waveCount) {
            withTransform({
                translate(points[it].x, points[it].y)
                rotate(
                    degrees = randomDegrees(),
                    pivot = Offset.Zero
                )
            }) {
                drawWaveShadow(
                    color = if (choices.brightWaves) pastelRainbow.random() else randomGrey(),
                    shadow = if (choices.brightWaves) vividRainbow.random() else randomGrey(),
                    Offset.Zero
                )
            }
        }
    }
}

fun DrawScope.drawWaveShadow(color: Color, shadow: Color, offset: Offset) {
    val delta = Offset(50f, 80f)
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
    zigzag.lineTo(center.x + delta.x + delta.x / 2, center.y- delta.y)
    drawPath(zigzag, color, style = Stroke(width = 10f))
}