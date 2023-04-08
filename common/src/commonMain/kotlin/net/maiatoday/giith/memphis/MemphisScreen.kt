package net.maiatoday.giith.memphis

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import getPlatformName

@Composable
fun MemphisScreen() {
    var choices by remember { mutableStateOf(MemphisChoices()) }

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
        ) { choices = it }
        Surface(modifier = pageModifier.onSizeChanged {}) {
            AllTheTriangles(fill = choices.triangleFill, spacingDp = choices.spacingTriangle, sizeDp = choices.triangleSize)
            AllTheDonuts(fill = choices.dotFill, spacingDp = choices.spacingDot, sizeDp = choices.dotSize)
            AllTheWaves(spacingDp = choices.spacingWave, waveSizeDp = choices.waveSize)
        }
    }
}
