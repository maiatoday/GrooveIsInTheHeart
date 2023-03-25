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
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.roots.*
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
                switchChildScreen = { screen -> screenState = screen }
            )
            Screen.ColorSwatches -> ColorSwatchesScreen { screenState = Screen.Home }
            Screen.DoodleSketch -> DoodleSketchScreen { screenState = Screen.Home }
            Screen.RainbowText -> RainbowTextScreen { screenState = Screen.Home }
            Screen.Blink -> BlinkScreen { screenState = Screen.Home }
            Screen.VisitorCounter -> VisitorCounterScreen { screenState = Screen.Home }
            Screen.GlitterPointer -> GlitterPointerScreen { screenState = Screen.Home }
            Screen.UnderConstruction -> UnderConstructionScreen { screenState = Screen.Home }
            Screen.HeartPath -> HeartPathScreen { screenState = Screen.Home }
            Screen.GuestBook -> GuestBookScreen { screenState = Screen.Home }
            Screen.Links -> LinksScreen { screenState = Screen.Home }
        }
    }
}

expect fun getPlatformName(): String
