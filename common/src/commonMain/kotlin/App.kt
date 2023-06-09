import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import net.maiatoday.giith.demos.d_blink.BlinkScreen
import net.maiatoday.giith.ui.colorSwatches.ColorSwatchesScreen
import net.maiatoday.giith.demos.i_glitter.GlitterPointerScreen
import net.maiatoday.giith.demos.g_heartpath.HeartPathScreen
import net.maiatoday.giith.navigation.roots.MyBookmarksScreen
import net.maiatoday.giith.demos.a_memphis.MemphisScreen
import net.maiatoday.giith.navigation.Screen.*
import net.maiatoday.giith.navigation.roots.GuestBookScreen
import net.maiatoday.giith.navigation.roots.HomeScreen
import net.maiatoday.giith.demos.f_rainbowtext.RainbowTextScreen
import net.maiatoday.giith.demos.b_stars.StarsScreen
import net.maiatoday.giith.ui.GrooveTheme
import net.maiatoday.giith.ui.ThemeChoice.Comic
import net.maiatoday.giith.ui.ThemeChoice.Times
import net.maiatoday.giith.demos.h_underconstruction.UnderConstructionScreen
import net.maiatoday.giith.demos.e_visitorcounter.VisitorCounterScreen
import net.maiatoday.giith.demos.c_wallpaper.WallpaperScreen

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

fun supportsGifs():Boolean = getPlatformName() != "Android"
fun isAndroid():Boolean = getPlatformName() == "Android"

expect fun getPlatformName(): String

expect fun openBrowser(url:String)

@Composable
expect fun GifWrap(gifResource: String, show:Boolean = true, size: Dp = 100.dp)
