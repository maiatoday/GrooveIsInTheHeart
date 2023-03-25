import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.components.Choices
import net.maiatoday.giith.components.ChoicesPanel
import net.maiatoday.giith.components.MAX_DOT_COUNT
import net.maiatoday.giith.components.Page
import net.maiatoday.giith.navigation.roots.ColorSwatchesScreen
import net.maiatoday.giith.navigation.roots.HomeScreen
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.roots.DoodleSketchScreen
import net.maiatoday.giith.sketch.AllTheDots
import net.maiatoday.giith.sketch.AllTheLines
import net.maiatoday.giith.tools.buildPoints
import net.maiatoday.giith.ui.GrooveTheme

@Composable
fun App() {
    var screenState by remember { mutableStateOf<Screen>(Screen.Home) }
    GrooveTheme {
        when (screenState) {
            Screen.Home -> HomeScreen(
                onColorSwatches = { screenState = Screen.ColorSwatches },
                onDoodleSketch = { screenState = Screen.DoodleSketch }
            )
            Screen.ColorSwatches -> ColorSwatchesScreen { screenState = Screen.Home }
            Screen.DoodleSketch -> DoodleSketchScreen { screenState = Screen.Home }
            else -> DoodleSketchScreen { screenState = Screen.DoodleSketch }
        }
    }
}

expect fun getPlatformName(): String
