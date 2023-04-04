package net.maiatoday.giith.memphis

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import getPlatformName
import net.maiatoday.giith.tools.buildPoints
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
            if (choices.dotCount > 0) AllTheDonuts(choices, donutPoints)
            if (choices.waveCount > 0) AllTheWaves(choices, wavePoints)
            if (choices.triangleCount > 0) AllTheTriangles(choices, trianglePoints)
        }
    }
}

@Composable
fun AllTheDonuts(choices: MemphisChoices, points: List<Offset>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        repeat(choices.dotCount) {
            drawCircle(
                color = if (choices.brightDots) pastelRainbow.random() else randomGrey(),
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
            drawTriangle(
                color = if (choices.brightTriangles) pastelRainbow.random() else randomGrey(),
                shadow = if (choices.brightTriangles) vividRainbow.random() else randomGrey(),
                points[it]
            )

        }
    }
}

fun DrawScope.drawTriangle(color: Color, shadow: Color, offset: Offset) {
    drawLine(shadow, offset, Offset(offset.x+10, offset.y+20))
    drawLine(color, Offset(offset.x+2, offset.y+2), Offset(offset.x+2+10, offset.y+2+20))
}

@Composable
fun AllTheWaves(choices: MemphisChoices, points: List<Offset>) {
    Canvas(modifier = Modifier.fillMaxSize()) {
        repeat(choices.waveCount) {
            drawWave(
                color = if (choices.brightWaves) pastelRainbow.random() else randomGrey(),
                shadow = if (choices.brightWaves) vividRainbow.random() else randomGrey(),
                points[it]
            )
        }
    }

}

fun DrawScope.drawWave(color: Color, shadow: Color, offset: Offset) {

}