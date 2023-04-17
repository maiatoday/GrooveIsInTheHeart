package net.maiatoday.giith.navigation.roots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import getPlatformName
import net.maiatoday.giith.demos.c_wallpaper.UltraVioletBox
import net.maiatoday.giith.demos.d_blink.BlinkText
import net.maiatoday.giith.demos.d_blink.TheGhosts
import net.maiatoday.giith.demos.e_visitorcounter.Counter
import net.maiatoday.giith.demos.f_rainbowtext.GradientTextShimmer
import net.maiatoday.giith.demos.f_rainbowtext.MultiColorSmoothText
import net.maiatoday.giith.demos.f_rainbowtext.SnappyRainbowText
import net.maiatoday.giith.demos.g_heartpath.CandyHeartPulse
import net.maiatoday.giith.demos.g_heartpath.ShimmerDivider
import net.maiatoday.giith.demos.h_underconstruction.Chevron
import net.maiatoday.giith.demos.h_underconstruction.UnderConstructionMarquee
import net.maiatoday.giith.demos.i_glitter.GlitterBox
import net.maiatoday.giith.navigation.Screen
import net.maiatoday.giith.navigation.Screen.*
import net.maiatoday.giith.ui.*
import net.maiatoday.giith.ui.components.*

@Composable
fun HomeScreen(
    groovy: Boolean = false,
    switchChildScreen: (screen: Screen) -> Unit = {}
) {
    if (groovy) GroovyHome(switchChildScreen = switchChildScreen)
    else SimpleHome(switchChildScreen = switchChildScreen)
}

@Composable
fun SimpleHome(modifier: Modifier = Modifier, switchChildScreen: (screen: Screen) -> Unit = {}) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            for (s in Screen.values()) {
                if (s !in listOf(Home, GuestBook, MyBookmarks)) {
                    Button(onClick = { switchChildScreen(s) }) {
                        Text(s.toString())
                    }
                }
            }
        }
    }
}

@Composable
fun GroovyHome(modifier: Modifier = Modifier, switchChildScreen: (screen: Screen) -> Unit = {}) {
    var showGifs by remember { mutableStateOf(getPlatformName() != "Android") }
    Surface(modifier = modifier.fillMaxSize()) {
        UltraVioletBox()
        Box(
            modifier = Modifier
                .padding(64.dp)
                .background(brush = SolidColor(BlueyBlack), alpha = 0.7f)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TheGhosts(modifier = Modifier.padding(8.dp).size(80.dp))
                    GradientTextShimmer(
                        modifier = Modifier.clickable { showGifs = !showGifs }.padding(8.dp),
                        text = "Welcome to my corner of the Internet",
                        style = MaterialTheme.typography.headlineMedium,
                        colors = pastelRainbow
                    )
                    TheGhosts(modifier = Modifier.padding(8.dp).size(80.dp))
                }
                ShimmerDivider(height = 8.dp, colors = vividRainbow)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    for (s in Screen.values()) {
                        if (s != Home) {
                            item {
                                Row(
                                    Modifier
                                        .border(width = 2.dp, color = MyPonyHair)
                                        .clickable { switchChildScreen(s) }
                                        .padding(8.dp)
                                ) {
                                    GifForScreen(s, showGifs)
                                    Text(
                                        modifier = Modifier
                                            .padding(8.dp),
                                        text = s.toString(),
                                        textDecoration = TextDecoration.Underline
                                    )
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Chevron(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                UnderConstructionMarquee()
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    GuestBook(show = showGifs)
                    BlinkText(
                        text = "Sign the Guest Book",
                        color = Lime,
                        modifier = Modifier
                            .clickable { switchChildScreen(GuestBook) }
                            .padding(8.dp),
                        style = MaterialTheme.typography.headlineMedium,
                        durationMillis = 2000,
                        textDecoration = TextDecoration.Underline
                    )
                    ConstructionWorker(show = showGifs)
                    BlinkText(
                        text = "My Bookmarks",
                        color = SummerSky,
                        modifier = Modifier
                            .clickable { switchChildScreen(MyBookmarks) }
                            .padding(8.dp),
                        style = MaterialTheme.typography.headlineMedium,
                        durationMillis = 2000,
                        textDecoration = TextDecoration.Underline
                    )
                    Link2(show = showGifs)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    NetscapeLogo(show = showGifs)
                    Pony(show = showGifs)
                    Baby(show = showGifs)
                    VisitorCounterFake()
                    Baby(show = showGifs)
                    Pony(show = showGifs)
                    ComposeLogo()
                }
            }
        }
        GlitterBox(rainbow = pastelRainbow)
    }
}

@Composable
fun GifForScreen(screen: Screen, showGifs: Boolean = true) {
    when (screen) {
        Home -> {}
        ColorSwatches -> Troll(size = 48.dp, show = showGifs)
        Wallpaper -> Hot(show = showGifs)
        Memphis -> Pyramid(show = showGifs)
        Stars -> StarSpin(show = showGifs)
        Blink -> FlashingGhost(show = showGifs)
        RainbowText -> Rainbow(show = showGifs)
        VisitorCounter -> Number0(show = showGifs)
        GlitterPointer -> Wand(show = showGifs)
        HeartPath -> DancerGirlRainbow(show = showGifs)
        UnderConstruction -> Flame(size = 48.dp, show = showGifs)
        GuestBook -> GuestBook(size = 48.dp, show = showGifs)
        MyBookmarks -> Link2(show = showGifs)
    }

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun VisitorCounterFake() {
    var count by remember { mutableStateOf(12910) }
    Row(modifier = Modifier
        .wrapContentSize()
        .clickable { count++ }
        .border(width = 2.dp, color = Lint)
        .padding(8.dp)) {
        Column {
            MultiColorSmoothText(text = "Visitors", duration = 1000)
            Counter(count = count, width = 8, onClick = { count++ })
            SnappyRainbowText(text = "Stay Groovy")
        }
        Box(modifier = Modifier.size(65.dp)) {
            CandyHeartPulse(initialValue = 0.2f, targetValue = 0.8f)
        }
    }
}