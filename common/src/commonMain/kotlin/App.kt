import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.blink.BlinkScreen
import net.maiatoday.giith.colorSwatches.ColorSwatchesScreen
import net.maiatoday.giith.glitter.GlitterPointerScreen
import net.maiatoday.giith.heartpath.HeartPathScreen
import net.maiatoday.giith.mybookmarks.MyBookmarksScreen
import net.maiatoday.giith.memphis.MemphisScreen
import net.maiatoday.giith.navigation.Screen.*
import net.maiatoday.giith.navigation.roots.GuestBookScreen
import net.maiatoday.giith.navigation.roots.HomeScreen
import net.maiatoday.giith.rainbowtext.RainbowTextScreen
import net.maiatoday.giith.stars.StarsScreen
import net.maiatoday.giith.ui.GrooveTheme
import net.maiatoday.giith.ui.ThemeChoice.Comic
import net.maiatoday.giith.ui.ThemeChoice.Times
import net.maiatoday.giith.underconstruction.UnderConstructionScreen
import net.maiatoday.giith.visitorcounter.VisitorCounterScreen
import net.maiatoday.giith.wallpaper.WallpaperScreen

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
                    .padding(8.dp)
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
                Memphis -> MemphisScreen()
                Blink -> BlinkScreen()
                RainbowText -> RainbowTextScreen()
                VisitorCounter -> VisitorCounterScreen()
                GlitterPointer -> GlitterPointerScreen()
                UnderConstruction -> UnderConstructionScreen()
                Wallpaper -> WallpaperScreen()
                HeartPath -> HeartPathScreen()
                GuestBook -> GuestBookScreen()
                MyBookmarks -> MyBookmarksScreen()
                Stars -> StarsScreen()
            }
        }
    }
}

expect fun getPlatformName(): String

expect fun isAndroid(): Boolean

expect fun openBrowser(url:String)
