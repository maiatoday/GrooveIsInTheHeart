package net.maiatoday.giith.navigation.roots

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import getPlatformName
import net.maiatoday.giith.components.Choices
import net.maiatoday.giith.components.ChoicesPanel
import net.maiatoday.giith.components.MAX_DOT_COUNT
import net.maiatoday.giith.components.Page
import net.maiatoday.giith.sketch.AllTheDots
import net.maiatoday.giith.sketch.AllTheLines
import net.maiatoday.giith.tools.buildPoints

@Composable
fun DoodleSketchScreen(onBack: () -> Unit = { }) {
    var choices by remember { mutableStateOf(Choices()) }
    var points by remember { mutableStateOf(buildPoints(choices.size, MAX_DOT_COUNT)) }

    val settingsModifier = Modifier
        .requiredWidth(200.dp)
        .fillMaxHeight()
        .clipToBounds()

    val pageModifier = Modifier
        .requiredWidth(1000.dp)
        .fillMaxHeight()
        .clipToBounds()
    Row(modifier = Modifier.wrapContentSize()) {
        Page(modifier = pageModifier.onSizeChanged {
            points = buildPoints(it, MAX_DOT_COUNT)
            choices = choices.copy(size = it)
        }) {
            if (choices.showLines) AllTheLines(choices, points)
            if (choices.showDots) AllTheDots(choices, points)
        }
        ChoicesPanel(
            modifier = settingsModifier,
            choices = choices,
            version = "Hello ${getPlatformName()}",
            onNewPoints = { points = buildPoints(choices.size, MAX_DOT_COUNT) },
            onBack = onBack
        ) { choices = it }
    }
}