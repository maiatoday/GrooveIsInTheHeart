package net.maiatoday.giith.memphis

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.StepSlider

const val MIN_SHAPE_COUNT = 0
const val MAX_SHAPE_COUNT = 200

data class MemphisChoices(
    val dotCount: Int = 30,
    val triangleCount: Int = 30,
    val waveCount: Int = 30,
    val brightDots:Boolean = true,
    val brightTriangles:Boolean = true,
    val brightWaves:Boolean = true,
    val size: IntSize = IntSize(600, 600)
)

val padding = Modifier.padding(8.dp)

@Composable
fun MemphisPanel(
    modifier: Modifier,
    choices: MemphisChoices,
    version: String = "",
    onNewPoints: () -> Unit = {},
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
            StepSlider(
                initialValue = choices.dotCount,
                minValue = MIN_SHAPE_COUNT,
                maxValue = MAX_SHAPE_COUNT,
                label = "Donut count"
            ) {
                onValueChange(choices.copy(dotCount = it))
            }
        }
        item {
            Text(modifier = padding, text = "Bright donuts")
            Switch(modifier = padding, checked = choices.brightDots, onCheckedChange = { newValue ->
                onValueChange(choices.copy(brightDots = newValue))
            })
        }
        item {
            StepSlider(
                initialValue = choices.triangleCount,
                minValue = MIN_SHAPE_COUNT,
                maxValue = MAX_SHAPE_COUNT,
                label = "Triangle count"
            ) {
                onValueChange(choices.copy(triangleCount = it))
            }
        }
        item {
            Text(modifier = padding, text = "Bright triangles")
            Switch(modifier = padding, checked = choices.brightTriangles, onCheckedChange = { newValue ->
                onValueChange(choices.copy(brightTriangles = newValue))
            })
        }
        item {
            StepSlider(
                initialValue = choices.waveCount,
                minValue = MIN_SHAPE_COUNT,
                maxValue = MAX_SHAPE_COUNT,
                label = "Wave count"
            ) {
                onValueChange(choices.copy(waveCount = it))
            }
        }
        item {
            Text(modifier = padding, text = "Bright waves")
            Switch(modifier = padding, checked = choices.brightWaves, onCheckedChange = { newValue ->
                onValueChange(choices.copy(brightWaves = newValue))
            })
        }
        item {
            Button(modifier = padding, onClick = onNewPoints) {
                Text("New points")
            }
        }
        item {
            Text(modifier = padding, text = version)
        }
    }
}

