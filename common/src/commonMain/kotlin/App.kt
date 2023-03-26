import androidx.compose.runtime.*
import net.maiatoday.giith.blink.BlinkScreen
import net.maiatoday.giith.glitter.GlitterPointerScreen
import net.maiatoday.giith.navigation.Screen.*
import net.maiatoday.giith.navigation.roots.*
import net.maiatoday.giith.rainbowtext.RainbowTextScreen
import net.maiatoday.giith.sketch.DoodleSketchScreen
import net.maiatoday.giith.ui.GrooveTheme
import net.maiatoday.giith.underconstruction.UnderConstructionScreen
import net.maiatoday.giith.visitorcounter.VisitorCounterScreen

@Composable
fun App() {
    var screenState by remember { mutableStateOf(Home) }
    GrooveTheme {
        when (screenState) {
            Home -> HomeScreen(
                switchChildScreen = { screen -> screenState = screen }
            )
            ColorSwatches -> ColorSwatchesScreen { screenState = Home }
            DoodleSketch -> DoodleSketchScreen { screenState = Home }
            RainbowText -> RainbowTextScreen { screenState = Home }
            Blink -> BlinkScreen { screenState = Home }
            VisitorCounter -> VisitorCounterScreen { screenState = Home }
            GlitterPointer -> GlitterPointerScreen { screenState = Home }
            UnderConstruction -> UnderConstructionScreen { screenState = Home }
            HeartPath -> HeartPathScreen { screenState = Home }
            GuestBook -> GuestBookScreen { screenState = Home }
            Links -> LinksScreen { screenState = Home }
        }
    }
}

expect fun getPlatformName(): String
