package net.maiatoday.giith.memphis

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.ui.components.StepSlider

data class MemphisChoices(
    val dotFill: Boolean = true,
    val triangleFill: Boolean = true,
    val radius:Int = 80
)

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
            StepSlider(
                initialValue = choices.radius,
                minValue = 80,
                maxValue = 320,
                label = "Spacing"
            ) {
                onValueChange(choices.copy(radius = it))
            }
        }
        item {
            Text(modifier = padding, text = "Donut fill")
            Switch(modifier = padding, checked = choices.dotFill, onCheckedChange = {
                onValueChange(choices.copy(dotFill = it))
            })
        }
        item {
            Text(modifier = padding, text = "Triangle fill")
            Switch(modifier = padding, checked = choices.triangleFill, onCheckedChange = {
                onValueChange(choices.copy(triangleFill = it))
            })
        }
        item {
            Text(modifier = padding, text = version)
        }
    }
}

