package net.maiatoday.giith.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.maiatoday.giith.tools.myFormat


@Composable
fun StepSlider(
    initialValue: Int,
    minValue: Int,
    maxValue: Int,
    label: String,
    onChange: (Int) -> Unit,
) {
    var value by remember { mutableStateOf(initialValue.toFloat()) }
    Column(
        modifier = Modifier.padding(10.dp)
    ) {
        Row {
            Text(text = "$label: ", fontSize = 14.sp)
            Text(text = "%d".myFormat(value.toInt()), fontSize = 14.sp)
        }
        Slider(
            value = value,
            valueRange = minValue.toFloat()..maxValue.toFloat(),
            onValueChange = { value = it; onChange(value.toInt()) },
            onValueChangeFinished = { onChange(value.toInt()) }
        )
    }
}