package net.maiatoday.giith.memphis

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun Memphis(modifier: Modifier = Modifier, choices: MemphisChoices) {
    Surface(modifier = modifier) {
        AllTheTriangles(fill = choices.triangleFill, spacingDp = choices.spacingTriangle, sizeDp = choices.triangleSize)
        AllTheDonuts(fill = choices.dotFill, spacingDp = choices.spacingDot, sizeDp = choices.dotSize)
        AllTheWaves(spacingDp = choices.spacingWave, waveSizeDp = choices.waveSize)
    }
}