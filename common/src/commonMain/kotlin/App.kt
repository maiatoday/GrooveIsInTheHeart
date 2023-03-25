import androidx.compose.runtime.*
import net.maiatoday.giith.blink.BlinkScreen
import net.maiatoday.giith.glitter.GlitterPointerScreen
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.roots.*
import net.maiatoday.giith.rainbowtext.RainbowTextScreen
import net.maiatoday.giith.ui.GrooveTheme
import net.maiatoday.giith.underconstruction.UnderConstructionScreen
import net.maiatoday.giith.visitorcounter.VisitorCounterScreen

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
