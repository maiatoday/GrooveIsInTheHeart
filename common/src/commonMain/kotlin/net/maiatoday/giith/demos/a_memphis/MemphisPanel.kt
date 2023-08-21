package net.maiatoday.giith.demos.a_memphis

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.demos.g_heartpath.SherbetBombDivider
import net.maiatoday.giith.ui.components.StepSlider

data class MemphisChoices(
    // controls how spaced out the elements are
    val spacingDot: Int = 80,
    // are the donuts filled or open
    val dotFill: Boolean = true,
    // some control of the donut size
    val dotSize: Int = 10,
    // controls how spaced out the elements are
    val spacingTriangle: Int = 80,
    // are the triangles filled or open
    val triangleFill: Boolean = true,
    // some control of the triangle size
    val triangleSize: Int = 10,
    // controls how spaced out the elements are
    val spacingWave: Int = 80,
    // wave size in width and height
    val waveSize: IntSize = IntSize(40, 10)
)

const val SPACE_MIN = 30
const val SPACE_MAX = 320

const val SIZE_MIN = 0
// we can't use SIZE_MAX as there is a #define in iOS
const val PLUGH = 80

val padding = Modifier.padding(8.dp)

@Composable
fun MemphisPanel(
    modifier: Modifier,
    choices: MemphisChoices,
    version: String = "",
    onValueChange: (MemphisChoices) -> Unit
) {

    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                "My Memphis ",
                modifier = padding,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold,
            )
        }
        item {
            SherbetBombDivider(modifier)
        }
        item {
            StepSlider(
                initialValue = choices.spacingDot,
                minValue = SPACE_MIN,
                maxValue = SPACE_MAX,
                label = "Spacing Dot"
            ) {
                onValueChange(choices.copy(spacingDot = it))
            }
        }
        item {
            Text(modifier = padding, text = "Donut fill")
            Switch(modifier = padding, checked = choices.dotFill, onCheckedChange = {
                onValueChange(choices.copy(dotFill = it))
            })
        }
        item {
            StepSlider(
                initialValue = choices.dotSize,
                minValue = SIZE_MIN,
                maxValue = PLUGH,
                label = "Donut size"
            ) {
                onValueChange(choices.copy(dotSize = it))
            }
        }
        item {
            SherbetBombDivider(modifier)
        }
        item {
            StepSlider(
                initialValue = choices.spacingTriangle,
                minValue = SPACE_MIN,
                maxValue = SPACE_MAX,
                label = "Spacing triangle"
            ) {
                onValueChange(choices.copy(spacingTriangle = it))
            }
        }
        item {
            Text(modifier = padding, text = "Triangle fill")
            Switch(modifier = padding, checked = choices.triangleFill, onCheckedChange = {
                onValueChange(choices.copy(triangleFill = it))
            })
        }
        item {
            StepSlider(
                initialValue = choices.triangleSize,
                minValue = SIZE_MIN,
                maxValue = PLUGH,
                label = "Triangle size"
            ) {
                onValueChange(choices.copy(triangleSize = it))
            }
        }
        item {
            SherbetBombDivider(modifier)
        }
        item {
            StepSlider(
                initialValue = choices.spacingWave,
                minValue = SPACE_MIN,
                maxValue = SPACE_MAX,
                label = "Spacing wave"
            ) {
                onValueChange(choices.copy(spacingWave = it))
            }
        }
        item {
            StepSlider(
                initialValue = choices.waveSize.width,
                minValue = SIZE_MIN,
                maxValue = PLUGH,
                label = "Wave width"
            ) {
                onValueChange(choices.copy(waveSize = IntSize(width = it, height = choices.waveSize.height)))
            }
        }
        item {
            StepSlider(
                initialValue = choices.waveSize.height,
                minValue = SIZE_MIN,
                maxValue = PLUGH,
                label = "Wave height"
            ) {
                onValueChange(choices.copy(waveSize = IntSize(width = choices.waveSize.width, height = it)))
            }
        }
        item {
            SherbetBombDivider(modifier)
        }
        item {
            Text(modifier = padding, text = version)
        }
    }
}

