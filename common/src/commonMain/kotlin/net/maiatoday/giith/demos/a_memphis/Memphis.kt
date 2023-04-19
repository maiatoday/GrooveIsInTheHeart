package net.maiatoday.giith.demos.a_memphis

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier









//region Tribute to Memphis design
@Composable
fun Memphis(
    modifier: Modifier = Modifier,
    choices: MemphisChoices = MemphisChoices()
) {
    Surface(modifier = modifier) {
        AllTheTriangles(fill = choices.triangleFill, spacingDp = choices.spacingTriangle, sizeDp = choices.triangleSize)
        AllTheDonuts(fill = choices.dotFill, spacingDp = choices.spacingDot, sizeDp = choices.dotSize)
        AllTheWaves(spacingDp = choices.spacingWave, waveSizeDp = choices.waveSize)
    }
}
//endregion






