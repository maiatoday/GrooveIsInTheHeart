import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.maiatoday.giith.blink.BlinkScreen
import net.maiatoday.giith.colorSwatches.ColorSwatchesScreen
import net.maiatoday.giith.glitter.GlitterPointerScreen
import net.maiatoday.giith.memphis.MemphisScreen
import net.maiatoday.giith.navigation.Screen.*
import net.maiatoday.giith.navigation.roots.GuestBookScreen
import net.maiatoday.giith.navigation.roots.HeartPathScreen
import net.maiatoday.giith.navigation.roots.HomeScreen
import net.maiatoday.giith.navigation.roots.LinksScreen
import net.maiatoday.giith.rainbowtext.RainbowTextScreen
import net.maiatoday.giith.sketch.DoodleSketchScreen
import net.maiatoday.giith.wallpaper.TilesScreen
import net.maiatoday.giith.ui.GrooveTheme
import net.maiatoday.giith.ui.ThemeChoice.Comic
import net.maiatoday.giith.ui.ThemeChoice.Times
import net.maiatoday.giith.underconstruction.UnderConstructionScreen
import net.maiatoday.giith.visitorcounter.VisitorCounterScreen

@Composable
fun App() {
    var groovy by remember { mutableStateOf(false) }
    var screenState by remember { mutableStateOf(Home) }
    var themeChoice by remember { mutableStateOf(Comic) }
    GrooveTheme(themeChoice = themeChoice) {
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Button(onClick = { screenState = Home }) { Text("Home") }
                Switch(
                    checked = themeChoice == Comic,
                    onCheckedChange = {
                        when (themeChoice) {
                            Comic -> themeChoice = Times
                            Times -> themeChoice = Comic
                        }
                    }
                )
                Switch(
                    checked = groovy,
                    onCheckedChange = {
                        groovy = !groovy
                    }
                )

            }
            when (screenState) {
                Home -> HomeScreen(groovy) { screen -> screenState = screen }
                ColorSwatches -> ColorSwatchesScreen()
                DoodleSketch -> DoodleSketchScreen()
                Memphis -> MemphisScreen()
                Blink -> BlinkScreen()
                RainbowText -> RainbowTextScreen()
                VisitorCounter -> VisitorCounterScreen()
                GlitterPointer -> GlitterPointerScreen()
                UnderConstruction -> UnderConstructionScreen()
                Tiles -> TilesScreen()
                HeartPath -> HeartPathScreen()
                GuestBook -> GuestBookScreen()
                Links -> LinksScreen()
            }
        }
    }
}

expect fun getPlatformName(): String
