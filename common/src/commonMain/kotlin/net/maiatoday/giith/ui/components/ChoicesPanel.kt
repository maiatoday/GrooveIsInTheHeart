package net.maiatoday.giith.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.maiatoday.giith.ui.GrooveTheme

const val MIN_DOT_COUNT = 2
const val MAX_DOT_COUNT = 200

data class Choices(
    val dotCount: Int = 100,
    val background: Color = Color.White,
    val showDots: Boolean = true,
    val rainbowDots: Boolean = true,
    val showLines: Boolean = true,
    val rainbowLines: Boolean = true,
    val color1: Color = Color.White,
    val color2: Color = Color.Black,
    val color3: Color = Color.Red,
    val size:IntSize = IntSize(600,600)
)

val padding = Modifier.padding(8.dp)

@Composable
fun ChoicesPanel(
    modifier: Modifier,
    choices: Choices,
    version:String = "",
    onNewPoints: () -> Unit = {},
    onBack: () -> Unit = {},
    onValueChange: (Choices) -> Unit
) {

    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                "Choices",
                modifier = padding,
                color = MaterialTheme.colors.primaryVariant,
                fontWeight = FontWeight.Bold,
            )
        }

        item {
            Text(modifier = padding, text = "Show circles")
            Switch(modifier = padding, checked = choices.showDots, onCheckedChange = { newValue ->
                onValueChange(choices.copy(showDots = newValue))
            })
        }

        item {
            Text(modifier = padding, text = "Rainbow circles")
            Switch(modifier = padding, checked = choices.rainbowDots, onCheckedChange = { newValue ->
                onValueChange(choices.copy(rainbowDots = newValue))
            })
        }

        item {
            Text(modifier = padding, text = "Show lines")
            Switch(modifier = padding, checked = choices.showLines, onCheckedChange = { newValue ->
                onValueChange(choices.copy(showLines = newValue))
            })
        }
        item {
            Text(modifier = padding, text = "Rainbow lines")
            Switch(modifier = padding, checked = choices.rainbowLines, onCheckedChange = { newValue ->
                onValueChange(choices.copy(rainbowLines = newValue))
            })
        }
        item {
            StepSlider(
                initialValue = choices.dotCount,
                minValue = MIN_DOT_COUNT,
                maxValue = MAX_DOT_COUNT,
                label = "Dot count"
            ) {
                onValueChange(choices.copy(dotCount = it))
            }
        }
        item {
            Button(modifier = padding, onClick = onNewPoints) {
                Text("New points")
            }
        }
        item {
            Text(modifier = padding, text = version)
        }

        item {
            BackButton(Modifier.padding(8.dp), onBack)
        }
    }
}

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
            Text(text = "%d".format(value.toInt()), fontSize = 14.sp)
        }
        Slider(
            value = value,
            valueRange = minValue.toFloat()..maxValue.toFloat(),
            onValueChange = { value = it; onChange(value.toInt()) },
            onValueChangeFinished = { onChange(value.toInt()) }
        )
    }
}

@Composable
fun ColorPicker(modifier: Modifier = Modifier, initialValue: Color, onChange: (Color) -> Unit) {
    var color by remember { mutableStateOf(initialValue) }
    Row(modifier = modifier) {
        Box(modifier = Modifier.background(color).width(50.dp).fillMaxHeight().padding(8.dp))
        Column {
            Text("Red")
            Slider(
                value = color.red,
                valueRange = 0.toFloat()..255.toFloat(),
                onValueChange = { color = color.copy(red = it); onChange(color) },
                onValueChangeFinished = { onChange(color) }
            )
            Text("Green")
            Slider(
                value = color.red,
                valueRange = 0.toFloat()..255.toFloat(),
                onValueChange = { color = color.copy(green = it); onChange(color) },
                onValueChangeFinished = { onChange(color) }
            )
            Text("Blue")
            Slider(
                value = color.red,
                valueRange = 0.toFloat()..255.toFloat(),
                onValueChange = { color = color.copy(blue = it); onChange(color) },
                onValueChangeFinished = { onChange(color) }
            )
        }

    }
}


@Composable
fun DoodleChoicesPanelPreview() {
    GrooveTheme {
        val modifier = Modifier
            .fillMaxSize()
            .clipToBounds()
        ChoicesPanel(modifier, Choices()) {}
    }
}

@Composable
fun ColorPickerPreview() {
    val modifier = Modifier
        .fillMaxSize()
        .clipToBounds()
    ColorPicker(modifier, Color.Magenta) {}
}